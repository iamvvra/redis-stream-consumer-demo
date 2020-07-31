package com.example.redisstreamconsumerdemo;

import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.stream.StreamListener;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

// @Component
public class MyStreamListener implements StreamListener<String, ObjectRecord<String, MyBean>> {

    // @Autowired
    private RedisTemplate<String, MyBean> redisTemplate;
    private String group;
    private String consumer;

    public MyStreamListener(RedisTemplate<String, MyBean> redisTemplate, String group, String consumer) {
        this.group = group;
        this.consumer = consumer;
        this.redisTemplate = redisTemplate;
    }

    private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

    @Override
    public void onMessage(ObjectRecord<String, MyBean> message) {
        EtmPoint point = etmMonitor.createPoint("MyStreamListener:onMessage");
        try {
            System.out.println(group + ", " + consumer + " -> " + message);
            redisTemplate.opsForStream().acknowledge(group, message);
        } finally {
            point.collect();
        }
    }

}