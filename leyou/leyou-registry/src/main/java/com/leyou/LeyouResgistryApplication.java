package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 声明当前springboot应用是一个eureka服务中心
public class LeyouResgistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeyouResgistryApplication.class);
    }
}
