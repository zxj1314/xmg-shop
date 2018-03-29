package com.seemygo.server.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by zlb on 2017.09.28.
 */
@SpringBootApplication
@MapperScan("com.seemygo.server.goods.mapper")
@EnableTransactionManagement
public class StartApp {
    public static void main(String[] args) {
        SpringApplication.run(StartApp.class,args);

    }


}
