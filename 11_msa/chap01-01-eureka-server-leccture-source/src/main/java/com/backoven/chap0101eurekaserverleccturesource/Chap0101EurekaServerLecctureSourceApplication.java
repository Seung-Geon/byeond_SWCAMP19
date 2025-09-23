package com.backoven.chap0101eurekaserverleccturesource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer         // 유레카 서버는 반드시!! 어노테이션 추가할 것
public class Chap0101EurekaServerLecctureSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap0101EurekaServerLecctureSourceApplication.class, args);
    }

}
