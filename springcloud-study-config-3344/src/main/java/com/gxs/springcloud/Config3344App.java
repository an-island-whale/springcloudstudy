package com.gxs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: xuyaoyao
 * @Description:
 * @Date: Create in 17:03 2019/11/13
 */

@SpringBootApplication
@EnableConfigServer
public class Config3344App {
    public static void main(String[] args) {
        SpringApplication.run(Config3344App.class,args);
    }
}
