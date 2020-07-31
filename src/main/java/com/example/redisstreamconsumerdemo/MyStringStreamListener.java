package com.example.redisstreamconsumerdemo;

import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

@Component
// @Scope("prototype")
public class MyStringStreamListener implements StreamListener<String, MapRecord<String, String, String>> {

    // @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private String consumer;
    private String group;
    private EtmMonitor monitor;

    public MyStringStreamListener(RedisTemplate<String, String> redisTemplate, String group, String consumer) {
        this.redisTemplate = redisTemplate;
        this.group = group;
        this.consumer = consumer;
        monitor = EtmManager.getEtmMonitor();
    }

    @Override
    public void onMessage(MapRecord<String, String, String> message) {
        EtmPoint point = monitor.createPoint("MyStringStreamListener:onMessage");
        try {
            // System.out.println(group + ", " + consumer + "-> " + message);
            redisTemplate.opsForStream().acknowledge(group, message);
        } finally {
            point.collect();
        }

    }

}