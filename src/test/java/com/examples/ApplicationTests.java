package com.examples;

import com.examples.configurations.QueueEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        System.out.println("starter");
    }

    /**
     * 生产消费测试
     * @throws InterruptedException
     */
    @Test
    public void sendMessage() throws InterruptedException {
        String message = "6666";
        log.info("消息内容：{}", message);
        rabbitTemplate.convertAndSend(QueueEnum.DIRECT_EXAMPLE.getExchange(),QueueEnum.DIRECT_EXAMPLE.getRouteKey(), message);
        TimeUnit.SECONDS.sleep(2);
    }

    /**
     * 延时消息队列测试
     * @throws InterruptedException
     */
    @Test
    public void test01() throws InterruptedException {
        String content = "{\"id\":\"9\"}";
        log.info("消息内容：{}", content);
        rabbitTemplate.convertAndSend(QueueEnum.DIRECT_DELAYED_TEST.getExchange(), QueueEnum.DIRECT_DELAYED_TEST.getRouteKey(), content, message ->{
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            message.getMessageProperties().setDelay(5 * 1000);   // 毫秒为单位，指定此消息的延时时长
            return message;
        });
        // 等待消息消费完
        TimeUnit.SECONDS.sleep(10);
    }
    
}