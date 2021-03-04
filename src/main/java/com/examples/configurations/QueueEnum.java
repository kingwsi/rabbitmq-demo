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
    DIRECT_EXAMPLE("示例", "direct.exchange.example", QueueConst.EXAMPLE, "direct.routekey.example"),
    DIRECT_DELAYED_TEST("延时队列测试", "direct.exchange.delayed", QueueConst.DELAYED, "delayed.routekey.delayed");

    QueueEnum(String desc, String exchange, String queue, String routeKey) {
        this.desc = desc;
        this.exchange = exchange;
        this.queue = queue;
        this.routeKey = routeKey;
    }

    private String desc;

    private String exchange;

    private String queue;

    private String routeKey;

    @Override
    public String toString() {
        return exchange;
    }

    public static class QueueConst {
        final static String DELAYED = "direct.queue.delayed";
        final static String EXAMPLE = "direct.queue.example";
    }
}
