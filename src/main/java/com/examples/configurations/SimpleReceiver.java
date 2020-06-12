package com.examples.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * description: SimpleReceiver <br>
 * date: 2020/6/11 14:08 <br>
 * author: ws <br>
 * version: 1.0 <br>
 */
@Component
@RabbitListener(queues = "direct.example.queue")
@Slf4j
public class SimpleReceiver {

    @RabbitHandler
    public void receive(String in) {
        log.info("已消费，msg -> '{}'", in);
    }

}