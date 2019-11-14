package com.xuecheng.test.rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.xuecheng.test.rabbitmq.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Publish/subscribe    工作模式
 * 发布订阅模式：
 * 1、每个消费者监听自己的队列。
 * 2、生产者将消息发给broker，由交换机将消息转发到绑定此交换机的每个队列，每个绑定交换机的队列都将接收 到消息
 *
 * @Date 2019/9/17 11:16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Producer05_topics_springboot {
    @Autowired
    RabbitTemplate rabbitTemplate;
   @Test
    public void test01(){
       String message = "send email message to user";
       /**
        * 参数：
        * 1、交换机名称
        * 2、routingKey
        * 3、消息内容
        */
       rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_FANOUT_INFORM,"inform.email",message);
   }
}
