package cn.itcast.mq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testSimpleQueue(){
        String queueName = "simple.queue";
        String message = "hello springAmqp";
        rabbitTemplate.convertAndSend(queueName,message);
    }

    @Test
    public void workSimpleQueue() throws InterruptedException {
        String queueName = "simple.queue";
        String message = "hello springAmqp______";
        for(int i=1;i<=50;i++){
            rabbitTemplate.convertAndSend(queueName,message+i);
            Thread.sleep(20);
        }
    }

    @Test
    public void testFanoutExchange(){
        String exchange = "itcast.fanout";
        String message = "hello,everyone!";
        rabbitTemplate.convertAndSend(exchange,"",message);
    }

    @Test
    public void testDirectExchange(){
        String exchange = "itcast.direct";
        String message = "hello,blue!";
        rabbitTemplate.convertAndSend(exchange,"blue",message);
    }

    @Test
    public void testTopicExchange(){
        String exchange = "itcast.topic";
        String message = "今天天气不错!";
        rabbitTemplate.convertAndSend(exchange,"china.hh",message);
    }

    @Test
    public void testObject(){
        String exchange = "object.queue";
        Map<String,Object> message = new HashMap<>();
        message.put("name","lisi");
        message.put("age",12);
        rabbitTemplate.convertAndSend(exchange,message);
    }




}
