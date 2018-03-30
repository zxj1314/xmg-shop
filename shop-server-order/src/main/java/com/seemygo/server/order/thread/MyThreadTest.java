package com.seemygo.server.order.thread;

/**
 * @Author:zxj
 * @Desc:多线程简单示例测试
 * @Date:Created in 13:53 2018/1/11
 */
public class MyThreadTest {
    public static void main(String[] args) {
        for (int i = 1; i <=4; i++) {
            new MyThread().start();
        }
    }
}
