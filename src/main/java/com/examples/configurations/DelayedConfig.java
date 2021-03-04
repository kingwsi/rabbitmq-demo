package com.examples.configurations;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 延时消息队列配置 <br>
 * date: 2021/3/4 15:48 <br>
 * author: ws <br>
 * version: 1.0 <br>
 */
@Configuration
public class DelayedConfig {

    /**
     * 声明延时队列
     *
     * @return
     */
    @Bean
    public Queue delayPayQueue() {
        return new Queue(QueueEnum.DIRECT_DELAYED_TEST.getQueue(), true);
    }

    /**
     * 声明延时队列交换机
     *
     * @return
     */
    @Bean
    DirectExchange delayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        DirectExchange topicExchange = new DirectExchange(QueueEnum.DIRECT_DELAYED_TEST.getExchange(), true, false, args);
        topicExchange.setDelayed(true);
        return topicExchange;
    }

    /**
     * 绑定队列与交换机路由键
     *
     * @return
     */
    @Bean
    public Binding delayPayBind() {
        return BindingBuilder.bind(delayPayQueue()).to(delayExchange()).with(QueueEnum.DIRECT_DELAYED_TEST.getRouteKey());
    }
}
