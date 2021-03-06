package com.xuecheng.test.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Date 2019/9/17 14:10
 */
public class Consumer04_topics_sms {
    //队列名称
    private static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    private static final String EXCHANGE_FANOUT_INFORM = "exchange_topics_inform";

    public static void main(String[] args) {
        //创建一个与MQ的连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        //rabbitmq默认虚拟机名称为“/”,虚拟机相当于一个独立的mq服务器
        // 创建一个连接
        Connection connection = null;
        Channel channel = null;
        try {


            connection = factory.newConnection();
            //创建与交换机的通道,每个通道代表一个会话
            channel = connection.createChannel();
            //声明队列
            //channel.queueDeclare(String queue,boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
            /**
             * 参数明细：
             * 1、队列名称
             * 2、是否持久化
             * 3、是否独占此队列
             * 4、队列不用是否自动删除
             * 5、参数
             */
            channel.queueDeclare(QUEUE_INFORM_SMS, true, false, false, null);

            //声明交换机
            //参数：String exchange, String type
            /**
             * 参数明细：
             * 1、交换机的名称  exchange
             * 2、交换机的类型  type
             * fanout：对应的rabbitmq的工作模式是public/subscribe
             * direct：对应的Routing工作模式
             * topic：对应的Topic工作模式
             * headers：对应的headers工作模式
             */
            channel.exchangeDeclare(EXCHANGE_FANOUT_INFORM, BuiltinExchangeType.DIRECT);

            //进行交换机和队列绑定
            //参数：String queue, String exchange, String routingKey
            /**
             * 参数明细：
             * 1、queue 队列名称
             * 2、exchange 交换机名称
             * 3、routingKey 路由key，作用是交换机根据路由key的值将消息转发到指定的队列中，在发布订阅模式中调协为空字符串
             */
            channel.queueBind(QUEUE_INFORM_SMS, EXCHANGE_FANOUT_INFORM, QUEUE_INFORM_SMS);

            DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    long deliveryTag = envelope.getDeliveryTag();
                    String exchange = envelope.getExchange();
                    //消息内容
                    String message = new String(body, "utf-8");
                    System.out.println(message);
                }
            };

            channel.basicConsume(QUEUE_INFORM_SMS, true, defaultConsumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
