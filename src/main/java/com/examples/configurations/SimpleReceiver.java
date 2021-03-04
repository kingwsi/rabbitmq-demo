package com.examples.configurations;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * description: SimpleReceiver <br>
 * date: 2020/6/11 14:08 <br>
 * author: ws <br>
 * version: 1.0 <br>
 */
@Component
@Slf4j
public class SimpleReceiver {

    /**
     * 简单消费
     *
     */
    @RabbitListener(queues = QueueEnum.QueueConst.EXAMPLE)
    @RabbitHandler
    public void receive(String content) {
        log.info("消息队列[{}]消费成功{}", QueueEnum.DIRECT_EXAMPLE.getDesc(), content);
    }

    /**
     * 消费并确认
     *
     * @param content
     * @param message
     * @param channel
     */
    @RabbitListener(queues = QueueEnum.QueueConst.DELAYED)
    @RabbitHandler
    public void delayedReceive(String content, Message message, Channel channel) throws IOException {
        try {
            log.info("消息队列[{}]消费成功{}", QueueEnum.DIRECT_DELAYED_TEST.getDesc(), content);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("消息队列[{}]消费失败 err -> {}", QueueEnum.DIRECT_DELAYED_TEST.getDesc(), e.getMessage());
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        }
    }


}