### RabbitMQ使用示例
通过@Bean创建和绑定交换机、队列、路由键
###### 环境 
- jdk 8
- rabbitMQ 3.8.3
- 默认账号密码 guest/guest
- RabbitMQ官方文档 
[https://www.rabbitmq.com/getstarted.html](https://www.rabbitmq.com/getstarted.html) \
运行ApplicationTests中test方法 测试消息生产及消费\
1、基础队列演示 \
2、延时队列演示 

### 延时队列
使用`rabbitmq_delayed_message_exchange`插件实现延时消息队列

##### 安装插件
去[社区插件](https://www.rabbitmq.com/community-plugins.html)页面,找到rabbitmq_delayed_message_exchange <br>
下载`*.ez`格式插件后放入mq安装目录下`/plugins/` \
使用命令启用插件 
```shell script
rabbitmq-plugins enable rabbitmq_delayed_message_exchange
```