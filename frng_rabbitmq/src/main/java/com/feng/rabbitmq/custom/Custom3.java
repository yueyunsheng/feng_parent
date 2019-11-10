package com.feng.rabbitmq.custom;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "feng_2")
public class Custom3 {

    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("获取mq消息feng_2"+msg);
    }
}
