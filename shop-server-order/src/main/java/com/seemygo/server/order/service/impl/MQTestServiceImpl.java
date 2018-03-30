package com.seemygo.server.order.service.impl;

import com.xmg.shop.api.order.service.IMQTestComsumerService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MQTestServiceImpl implements IMQTestComsumerService {
    /**
     * 使用spring给我们提供的JMS监听注解，监听一个消息地点
     * 注意，监听的消息地点要和消息发送到的地点一致
     * @param userId 消息生产者发送过来的userId
     */
    @Override
    @JmsListener(destination = "mytest.queue")
    public void receiveMsg(String userId){
        System.out.println(userId);
    }

}
