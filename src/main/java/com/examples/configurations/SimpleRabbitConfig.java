package com.examples.configurations;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: SimpleRabbitConfig <br>
 * date: 2020/6/11 14:04 <br>
 * author: ws <br>
 * version: 1.0 <br>
 */
@Configuration
public class SimpleRabbitConfig {

    /**
     * 创建交换机
     * 交换机类型：
     * 1.direct 默认，路由键匹配则消息就投递到相应的队列
     * 2.fanout 发布/订阅模式，发送一条消息的时候，交换器会把消息广播到所有附加到这个交换器的队列上
     * 3.topic 匹配订阅模式，通配符匹配
     * 4.headers
     *
     * @return
     */


    @Bean
    DirectExchange messageDirect() {
        // 使用ExchangeBuilder新建交换机
        return (DirectExchange) ExchangeBuilder.directExchange(QueueEnum.DIRECT_EXAMPLE.getExchange()).durable(true).build();
    }

    @Bean
    public Queue queue() {
        return new Queue(QueueEnum.DIRECT_EXAMPLE.getQueue());
    }

    /**
     * 绑定队列和交换机
     *
     * @param exchange
     * @param queue
     * @return
     */
    @Bean
    Binding messageBinding(DirectExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(QueueEnum.DIRECT_EXAMPLE.getRouteKey());
    }
}