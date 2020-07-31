package com.example.redisstreamconsumerdemo;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import com.example.redisstreamconsumerdemo.beans.AmigoTxnRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import etm.core.renderer.MeasurementRenderer;
import etm.core.renderer.SimpleTextRenderer;

@RestController
public class RedisController {
    @Autowired
    private RedisTemplate<String, MyBean> redisTemplate;
    // @Autowired
    // private StringRedisTemplate stringRedisTemplate;
    long counter = 0;
    // private StreamOperations<String, String, String> opsForStream;
    Random random = new Random(Long.MAX_VALUE);

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    EtmMonitor monitor;
    private URL is;
    private AmigoTxnRequest amigoRequest;

    @Value("request.json")
    private ClassPathResource resource;

    public RedisController() {

    }

    @PostConstruct
    public void init() throws JsonParseException, JsonMappingException, IOException, URISyntaxException {

        byte[] content = Files.readAllBytes(Paths.get(resource.getFile().toURI()));
        // ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        // is = classloader.getResource("request.json");
        // byte[] content = Files.readAllBytes(Paths.get(is.toURI()));
        amigoRequest = mapper.readValue(content, AmigoTxnRequest.class);
        // opsForStream = stringRedisTemplate.opsForStream();// (new
        // Jackson2HashMapper(true));
    }

    @GetMapping("/streams/strings/{message}/{count}")
    public String appendToStream(@PathVariable String message, @PathVariable int count) {
        // System.out.println("monitor collecting? " + monitor.isCollecting());
        long start = System.currentTimeMillis();
        EtmPoint point = monitor.createPoint("appendToStream");
        // Map<byte[], byte[]> map = new HashMap<>();
        // map.put("id", message + "-" + counter);
        try {
            String rt = null;
            for (int i = 0; i < count; i++) {
                MyBean bean = MyBean.builder().id(++counter).desc(message + "--" + counter)
                        .name(message + "-" + counter).percent(random.nextFloat())
                        .total(new BigDecimal(random.nextLong())).value(random.nextDouble()).build();
                Map output = mapper.convertValue(bean, Map.class);
                MapRecord<String, Object, Object> data = MapRecord.create("streamx", output);
                ObjectRecord<String, AmigoTxnRequest> record = StreamRecords.newRecord().ofObject(amigoRequest)
                        .withStreamKey("streamx");
                // ObjectRecord<String, ObjectRecord<String, MyBean>> record =
                // ObjectRecord.create("streamx", record);
                RecordId rec = redisTemplate.opsForStream().add(record);
                rt = rec.getValue();
            }
            return rt + "-" + (System.currentTimeMillis() - start);
        } finally {
            point.collect();
        }
    }

    @GetMapping("strings/metrics")
    public String metrics() {
        try {
            StringWriter aWriter = new StringWriter();
            MeasurementRenderer renderer = new SimpleTextRenderer(aWriter);
            monitor.aggregate();
            monitor.render(renderer);
            return aWriter.toString();
        } finally {
            monitor.reset();
        }
    }
}