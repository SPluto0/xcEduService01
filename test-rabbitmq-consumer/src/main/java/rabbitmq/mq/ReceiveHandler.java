package rabbitmq.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.config.RabbitmqConfig;
/**
 * @Date 2019/9/18 20:43
 */
@Component //交给spring进行管理   @Service也可以
public class ReceiveHandler {

    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public void send_email(String msg){
        System.out.println(msg);
    }
}
