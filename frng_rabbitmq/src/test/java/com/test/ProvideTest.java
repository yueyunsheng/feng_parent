package com.test;

import com.feng.rabbitmq.RabbitmqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class ProvideTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void seadMsg(){
        rabbitTemplate.convertAndSend("feng","Mq Test!");

    }

    @Test
    public void seadMsg1(){
        rabbitTemplate.convertAndSend("projack","","分类模式");

    }


    @Test
    public void seadMsg2(){
        rabbitTemplate.convertAndSend("topic","good.u","主题模式");

    }
}
