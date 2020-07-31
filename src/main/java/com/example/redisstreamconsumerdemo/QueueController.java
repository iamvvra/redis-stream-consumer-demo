package com.example.redisstreamconsumerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @RestController
public class QueueController {
    @Autowired
    private JmsTemplate jmsTemplate;
    private int counter = 0;

    @GetMapping("queues/{message}/{count}")
    public long publish(@PathVariable String message, @PathVariable Integer count) {

        long start = System.currentTimeMillis();
        int now = ++counter;
        jmsTemplate.convertAndSend("myqueue", new String("message-" + now));
        return System.currentTimeMillis() - start;
    }

}