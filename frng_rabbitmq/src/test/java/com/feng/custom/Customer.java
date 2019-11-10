package com.feng.custom;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "feng")
public class Customer {

    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("获取mq消息"+msg);
    }
}
