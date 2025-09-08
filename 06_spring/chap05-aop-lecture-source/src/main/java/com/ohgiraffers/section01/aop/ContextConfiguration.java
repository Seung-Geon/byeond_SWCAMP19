package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.ohgiraffers.section01.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)    // 이걸 해줘야 Aspect가 적용된다.
public class ContextConfiguration {


}
