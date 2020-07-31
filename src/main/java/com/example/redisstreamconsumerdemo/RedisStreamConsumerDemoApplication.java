package com.example.redisstreamconsumerdemo;

import java.util.Map;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;
import com.esotericsoftware.kryo.util.Pool;
import com.example.redisstreamconsumerdemo.beans.AmigoTxnRequest;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.stream.Consumer;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.ReadOffset;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.data.redis.stream.StreamMessageListenerContainer.StreamMessageListenerContainerOptions;
import org.springframework.data.redis.stream.StreamReceiver;
import org.springframework.data.redis.stream.StreamReceiver.StreamReceiverOptions;
import org.springframework.data.redis.stream.Subscription;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import io.lettuce.core.ClientOptions;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.protocol.CommandArgs;
import io.lettuce.core.protocol.CommandKeyword;
import lombok.extern.slf4j.Slf4j;
import reactor.core.Disposable;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
@Slf4j
public class RedisStreamConsumerDemoApplication {

	@Value("${redis.server:localhost}")
	String redisServer;
	@Value("${redis.port:6379}")
	int redisPort;

	public static void main(String[] args) {
		SpringApplication.run(RedisStreamConsumerDemoApplication.class, args);
		setup();
	}

	@Bean
	private static EtmMonitor setup() {
		BasicEtmConfigurator.configure();
		EtmMonitor monitor = EtmManager.getEtmMonitor();
		// monitor.addPlugin(new EtmMonitorJmxPlugin());
		// monitor.addPlugin(new HttpConsoleServerPlugin());
		// monitor.addPlugin(new Rrd4jPlugin());
		// monitor.addPlugin(new Rrd4jImageGeneratorPlugin());
		monitor.start();

		// HttpConsoleServer server = new HttpConsoleServer(etmMonitor);
		return monitor;
	}

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		// RedisStandaloneConfiguration standaloneConfig = new
		// RedisStandaloneConfiguration("localhost", redisPort);
		RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration(
				"redis-ha-disabled-cluster-haproxy.redis-ha.svc.cluster.local", 6379);
		// standaloneConfig.setPassword("MZol2NmWcx");
		// RedisClusterConfiguration redisCluster = new
		// RedisClusterConfiguration().clusterNode("127.0.0.1", 6370);
		// redisCluster.setPassword("MZol2NmWcx");
		RedisSentinelConfiguration sentientlConfig = new RedisSentinelConfiguration().master("redismaster")
				.sentinel("redis-ha-disabled-cluster-haproxy.redis-ha.svc.cluster.local", 26379);
		// sentientlConfig.setPassword("MZol2NmWcx");
		// RedisStandaloneConfiguration redisStandalone = new
		// RedisStandaloneConfiguration("127.0.0.1", 6379);
		// redisStandalone.setPassword("MZol2NmWcx");

		// RedisClusterConfiguration clusterConfiguration = new
		// RedisClusterConfiguration().clusterNode("127.0.0.1", 30001)
		// .clusterNode("127.0.0.1", 30002).clusterNode("127.0.0.1",
		// 30003).clusterNode("127.0.0.1", 30004)
		// .clusterNode("127.0.0.1", 30005).clusterNode("127.0.0.1", 30006);
		RedisClusterConfiguration clusterConfiguration = new RedisClusterConfiguration()
				.clusterNode(new RedisNode("redis-ha-disabled-cluster-haproxy.redis-ha.svc.cluster.local", 6379));
		// clusterConfiguration.setPassword("MZol2NmWcx");
		LettuceClientConfiguration lettuceConfig = LettuceClientConfiguration.builder()
				// .readFrom(ReadFrom.ANY)
				.clientOptions(ClientOptions.builder().autoReconnect(true).build()).build();
		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(standaloneConfig,
				lettuceConfig);
		lettuceConnectionFactory.setShareNativeConnection(true);
		return lettuceConnectionFactory;
	}

	// @Bean
	// public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory
	// connectionFactory) {
	// StringRedisTemplate stringRedisTemplate = new
	// StringRedisTemplate(connectionFactory);
	// stringRedisTemplate.setEnableTransactionSupport(true);
	// return stringRedisTemplate;
	// }

	@Bean
	// @Benchmark
	public RedisTemplate<String, MyBean> readRedisTemplate(RedisConnectionFactory connectionFactory) {
		// System.out.println(KqueueProvider.isAvailable());
		RedisTemplate<String, MyBean> redisTemplate = new RedisTemplate<>();
		redisTemplate.setEnableTransactionSupport(true);
		GenericJackson2JsonRedisSerializer genSerializer = new GenericJackson2JsonRedisSerializer(
				MyBean.class.getSimpleName());
		Jackson2JsonRedisSerializer<MyBean> jacksonSerializer = new Jackson2JsonRedisSerializer<MyBean>(MyBean.class);
		KryoSerializer<MyBean> serializer = new KryoSerializer<MyBean>(MyBean.class, kryoPool());
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jacksonSerializer.setObjectMapper(om);
		redisTemplate.setKeySerializer(RedisSerializer.string());
		redisTemplate.setHashKeySerializer(RedisSerializer.string());
		// redisTemplate.setDefaultSerializer(serializer);
		redisTemplate.setValueSerializer(serializer);
		// redisTemplate.setHashValueSerializer(genSerializer);
		redisTemplate.setEnableDefaultSerializer(false);
		// redisTemplate.setHashKeySerializer(new
		// Jackson2JsonRedisSerializer<>(MyBean.class));
		// redisTemplate.setStringSerializer(RedisSerializer.string());
		// redisTemplate.setKeySerializer(RedisSerializer.string());
		// redisTemplate.setHashKeySerializer(new
		// Jackson2JsonRedisSerializer<>(MyBean.class));
		// redisTemplate.setHashValueSerializer(new
		// Jackson2JsonRedisSerializer<>(MyBean.class));
		// redisTemplate.setValueSerializer(new
		// Jackson2JsonRedisSerializer<>(MyBean.class));
		// redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}

	// @Bean
	// @Benchmark
	public Subscription streamer(RedisConnectionFactory redisConnectionFactory,
			RedisTemplate<String, MyBean> redisTemplate) {
		createConsumerGroup(redisTemplate, "streamx", "group-1");
		StreamMessageListenerContainerOptions<String, ObjectRecord<String, MyBean>> containerOptions = StreamMessageListenerContainerOptions
				.builder().targetType(MyBean.class).build();

		StreamMessageListenerContainer<String, ObjectRecord<String, MyBean>> container = StreamMessageListenerContainer
				.create(redisConnectionFactory, containerOptions);
		// Subscription subscription = container.receiveAutoAck(Consumer.from("group-1",
		// "reader-1"),
		// StreamOffset.create("streamx", ReadOffset.lastConsumed()), (message) -> {
		// System.out.println("group-1 -> " + message.getValue());
		// redisTemplate.opsForStream().acknowledge("group-1", message);
		// })
		Subscription subscription = null;
		int proc = Runtime.getRuntime().availableProcessors();
		for (int i = 0; i < proc; i++) {
			subscription = container.receiveAutoAck(Consumer.from("group-1", "reader-" + i),
					StreamOffset.create("streamx", ReadOffset.lastConsumed()),
					new MyStreamListener(redisTemplate, "group-1", "reader-" + i));
		}
		// });

		container.start();
		// subscription.isActive();
		return subscription;

	}

	// @Bean
	public Subscription streamer2(RedisConnectionFactory redisConnectionFactory,
			RedisTemplate<String, String> redisTemplate) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		createConsumerGroup(redisTemplate, "streamx", "group-2");
		StreamMessageListenerContainerOptions<String, MapRecord<String, String, String>> options = StreamMessageListenerContainerOptions
				.builder().build();
		StreamMessageListenerContainer<String, MapRecord<String, String, String>> container = StreamMessageListenerContainer
				.create(redisConnectionFactory, options);
		// Subscription subscription = container.receiveAutoAck(Consumer.from("group-2",
		// "reader-1"),
		// StreamOffset.create("streamx", ReadOffset.lastConsumed()), streamListener);
		// org.springframework.data.redis.connection.stream.Record.of
		Subscription subscription = container.receiveAutoAck(Consumer.from("group-2", "reader-2"),
				StreamOffset.create("streamx", ReadOffset.lastConsumed()), c -> {
					// mapper.readValue(c, valueTypeRef)
					Map<String, String> value = c.getValue();
					AmigoTxnRequest readValue = mapper.convertValue(value, AmigoTxnRequest.class);
					System.out.println("group-2, reader-1, " + readValue.getEventType());
					System.out.println("group-2, reader-1, " + readValue.getTxnDetails());
					// System.out.println("group-2, reader-1, " + value.getClass().getSimpleName());
					redisTemplate.opsForStream().acknowledge("group-2", c);
				});
		container.start();
		return subscription;
	}

	@Bean
	public Subscription streamer4(RedisConnectionFactory redisConnectionFactory,
			RedisTemplate<String, String> redisTemplate) {
		EtmMonitor etmMonitor = EtmManager.getEtmMonitor();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		createConsumerGroup(redisTemplate, "streamx", "group-2");
		StreamMessageListenerContainerOptions<String, ObjectRecord<String, AmigoTxnRequest>> options = StreamMessageListenerContainerOptions
				.builder().targetType(AmigoTxnRequest.class).build();
		StreamMessageListenerContainer<String, ObjectRecord<String, AmigoTxnRequest>> container = StreamMessageListenerContainer
				.create(redisConnectionFactory, options);
		for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
			container.receiveAutoAck(Consumer.from("group-2", "reader-" + i),
					StreamOffset.create("streamx", ReadOffset.lastConsumed()), msg -> {
						EtmPoint point = etmMonitor.createPoint("group-2-consumer-message");
						try {
							AmigoTxnRequest txnRequeszt = msg.getValue();
							redisTemplate.opsForStream().acknowledge("streamx", "group-2", msg.getId());
							// AmigoTxnRequest readValue = c.getValue();
							// System.out.println("group-2, reader-1, " + readValue.getEventType());
							// System.out.println("group-2, reader-1, " + readValue.getTxnDetails());
							// redisTemplate.opsForStream().acknowledge("group-2", c);
						} finally {
							point.collect();
						}
					});
		}

		container.start();
		return null;
	}

	// @Bean
	public Disposable streamer3(LettuceConnectionFactory redisConnectionFactory,
			RedisTemplate<String, String> redisTemplate) {
		// System.out.println("registering group-3");
		EtmMonitor etmMonitor = EtmManager.getEtmMonitor();
		createConsumerGroup(redisTemplate, "streamx", "group-3");
		StreamReceiverOptions<String, MapRecord<String, String, String>> options = StreamReceiverOptions.builder()
				.build();
		StreamReceiver<String, MapRecord<String, String, String>> streamReceiver = StreamReceiver
				.create(redisConnectionFactory, options);
		return streamReceiver.receive(Consumer.from("group-3", "reader-2"), StreamOffset.fromStart("streamx"))
				.doOnNext(c -> {
					System.out.println("group-3" + ", reader-2 --> " + c.getValue());
					redisTemplate.opsForStream().acknowledge("group-3", c);
				}).subscribeOn(Schedulers.parallel(), false).subscribe();
	}

	// @Benchmark
	public boolean createConsumerGroup(RedisTemplate<String, ?> redisTemplate, String key, String group) {
		try {
			CommandArgs<String, String> args = new CommandArgs<>(new StringCodec()).add(CommandKeyword.CREATE).add(key)
					.add(group).add("$").add("MKSTREAM");
			redisTemplate.opsForStream().createGroup(key, StreamOffset.fromStart(key).getOffset(), group);
			return true;
		} catch (Exception e) {
			System.err.println("seems the group exists");
		}
		return false;
	}

	@Bean
	public Pool<Kryo> kryoPool() {
		return new Pool<Kryo>(true, false, 8) {
			@Override
			protected Kryo create() {
				Kryo kryo = new Kryo();
				kryo.register(MyBean.class);
				kryo.setDefaultSerializer(CompatibleFieldSerializer.class);
				return kryo;
			}
		};
	}
}
