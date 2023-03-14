package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    //声明FanoutExchange交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("itcast.fanout");
    }
    //声明第一个队列
    @Bean
    public Queue FanoutQueue1(){
        return new Queue("fanout.queue1");
    }
    //绑定队列1和交换机
    @Bean
    public Binding bindingQueue1(Queue FanoutQueue1,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(FanoutQueue1).to(fanoutExchange);
    }

    //声明第二个队列
    @Bean
    public Queue FanoutQueue2(){
        return new Queue("fanout.queue2");
    }
    //绑定队列1和交换机
    @Bean
    public Binding bindingQueue2(Queue FanoutQueue2,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(FanoutQueue2).to(fanoutExchange);
    }
    @Bean
    public Queue ObjectQueue(){
        return new Queue("object.queue");
    }


}
