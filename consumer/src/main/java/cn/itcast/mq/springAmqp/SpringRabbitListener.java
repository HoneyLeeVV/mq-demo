package cn.itcast.mq.springAmqp;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Map;

@Component
public class SpringRabbitListener {
//    @RabbitListener(queues = "simple.queue")
//    public void listenSimpleQueueMessage(String msg){
//        System.out.println("simple.queue:【"+msg+"】");
//    }

    /**
    1.work
     */
//    @RabbitListener(queues = "simple.queue")
//    public void listenWorkQueueMessage1(String msg) throws InterruptedException {
//        System.out.println("消费者1接收到simple.queue:【"+msg+"】"+LocalTime.now());
//        Thread.sleep(20);
//    }
//    @RabbitListener(queues = "simple.queue")
//    public void listenWorkQueueMessage2(String msg) throws InterruptedException {
//        System.err.println("消费者2接收到simple.queue:【"+msg+"】"+LocalTime.now());
//        Thread.sleep(200);
//    }

    /**
     * 2.fanout
     */
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueueMessage1(String msg){
        System.out.println("消费者1接收到fanout.queue1:【"+msg+"】");
    }
    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueueMessage2(String msg){
        System.out.println("消费者2接收到fanout.queue2:【"+msg+"】");
    }
    /**
     * 3.direct
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "itcast.direct",type = ExchangeTypes.DIRECT),
            key = {"blue","red"}
    ))
    public void listenDirectQueueMessage1(String msg){
        System.out.println("消费者1接收到direct.queue1:【"+msg+"】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "itcast.direct",type = ExchangeTypes.DIRECT),
            key = {"green","red"}
    ))
    public void listenDirectQueueMessage2(String msg){
        System.out.println("消费者2接收到direct.queue2:【"+msg+"】");
    }
    /**
     * 4.topic
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "itcast.topic",type = ExchangeTypes.TOPIC),
            key = {"#.news"}
    ))
    public void listenTopicQueueMessage1(String msg){
        System.out.println("消费者1接收到direct.queue1:【"+msg+"】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "itcast.topic",type = ExchangeTypes.TOPIC),
            key = {"china.#"}
    ))
    public void listenTopicQueueMessage2(String msg){
        System.out.println("消费者2接收到direct.queue2:【"+msg+"】");
    }
    @RabbitListener(queues = "object.queue")
    public void listenObjectQueueMessage(Map<String,Object> msg){
        System.out.println("消费者2接收到direct.queue2:【"+msg+"】");
    }







}
