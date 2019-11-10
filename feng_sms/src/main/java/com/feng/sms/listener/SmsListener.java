package com.feng.sms.listener;

import com.feng.sms.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @RabbitHandler
    public void CustomerSms(Map<String,String> map){
        System.out.println("手机号："+map.get("moblie"));
        System.out.println("验证码："+map.get("checkCode"));
        String codePa ="{\"code\":\""+map.get("checkCode")+"\"}";
        smsUtil.sendSmsResponse(map.get("moblie"),codePa);
    }

    public static void main(String[] args) {
        String codePa = "{\"code\":\""+"s"+"\"}";
        System.out.println(codePa);
    }
}
