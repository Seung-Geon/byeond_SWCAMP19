package com.ohgiraffers.firstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FirstServiceController {
    /* 설명. @Value와 같이 application.yml 또는 컴퓨터 환경 변수를 불러오기 위한 객체 */
    private Environment env;
    @Autowired
    public FirstServiceController(Environment env) {
        this.env = env;
    }

    @GetMapping("/health")
    public String healthCheck() {
        /* 설명. Environment를 활용해서 local.server.port를 가져오면 동적으로 할당 된 실제 포트 번호 확인 가능 */
        return "I'm OK" + env.getProperty("local.server.port");
    }
}
