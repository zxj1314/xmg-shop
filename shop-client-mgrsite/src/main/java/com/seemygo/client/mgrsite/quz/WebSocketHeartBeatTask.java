package com.seemygo.client.mgrsite.quz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 功能：
 * 作者：chenjiefeng
 * 日期：2018/1/31
 * 版权所有：广州弘度信息科技有限公司 版权所有(C) 2017
 */
@Component
public class WebSocketHeartBeatTask {


    @Scheduled(cron = "0/10 * * * * ? ")
    public void cleanAlarm() {
        System.out.println("=============heartbeat======================");
    }
}
