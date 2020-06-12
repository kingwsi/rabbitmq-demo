package com.examples.configurations;

import lombok.Getter;

/**
 * description: QueueEnum <br>
 * date: 2020/6/11 15:00 <br>
 * author: ws <br>
 * version: 1.0 <br>
 */
@Getter
public enum QueueEnum {
    DIRECT_EXAMPLE("direct.example.exchange", "direct.example.queue", "direct.example.routekey");

    QueueEnum(String exchange, String queue, String routeKey) {
        this.exchange = exchange;
        this.queue = queue;
        this.routeKey = routeKey;
    }

    private String exchange;

    private String queue;

    private String routeKey;
}
