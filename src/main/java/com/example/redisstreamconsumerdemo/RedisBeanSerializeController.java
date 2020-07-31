package com.example.redisstreamconsumerdemo;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Random;

import javax.annotation.PostConstruct;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.Pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StreamOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import etm.core.monitor.EtmMonitor;
import etm.core.renderer.MeasurementRenderer;
import etm.core.renderer.SimpleTextRenderer;

@RestController
public class RedisBeanSerializeController {
    @Autowired
    private RedisTemplate<String, MyBean> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    long counter = 0;
    private StreamOperations<String, String, MyBean> opsForStream;
    Random random = new Random(Long.MAX_VALUE);

    @Autowired
    Pool<Kryo> kryoPool;

    @Autowired
    EtmMonitor monitor;

    public RedisBeanSerializeController() {

    }

    @PostConstruct
    public void init() {
        opsForStream = redisTemplate.opsForStream();// (new Jackson2HashMapper(true));
    }

    @GetMapping("streams/beans/{message}/{count}")
    public String appendToStream(@PathVariable String message, @PathVariable int count) {
        // System.out.println("monitor collecting? " + monitor.isCollecting());
        long start = System.currentTimeMillis();
        // Map<byte[], byte[]> map = new HashMap<>();
        // map.put("id", message + "-" + counter);

        String rt = null;
        Kryo kryo = kryoPool.obtain();
        for (int i = 0; i < count; i++) {
            MyBean bean = MyBean.builder().id(++counter).desc(message + "--" + counter).name(message + "-" + counter)
                    .percent(random.nextFloat()).total(new BigDecimal(random.nextLong())).value(random.nextDouble())
                    .build();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Output output = new Output(outputStream);
            kryo.writeClassAndObject(output, bean);
            ObjectRecord<String, byte[]> record = StreamRecords.newRecord().in("streamx")
                    .ofObject(outputStream.toByteArray()).withStreamKey("streamx");
            // ObjectRecord<String, ObjectRecord<String, MyBean>> record =
            // ObjectRecord.create("streamx", record);
            RecordId rec = stringRedisTemplate.opsForStream().add(record);
            rt = rec.getValue();
        }
        kryoPool.free(kryo);
        return rt + "-" + (System.currentTimeMillis() - start);
    }

    @GetMapping("beans/metrics")
    public String metrics() {
        StringWriter aWriter = new StringWriter();
        MeasurementRenderer renderer = new SimpleTextRenderer(aWriter);
        monitor.aggregate();
        monitor.render(renderer);
        return aWriter.toString();
    }
}