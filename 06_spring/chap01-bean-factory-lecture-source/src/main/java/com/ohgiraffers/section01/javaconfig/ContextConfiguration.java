package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 컨테이너의 콩이기도 하고, 설정파일이기도 함
@Configuration("config")
public class ContextConfiguration {

    /* 설명. 메소드명이 기본 bean의 이름이 되고, 다른 이름을 하고 싶으면 어노테이션에 이름을 작성할 수 있다. */
//    @Bean   // Spring이 프로그램 실행시 호출하는 메소드의 반환값을 이용해 Bean을 만듬, 메소드의 이름이 bean의 이름이 됨
    @Bean(name = "member")  //bean의 이름 변경
    public MemberDTO getMember() {
        return new MemberDTO(1, "user01", "pass01", "홍길동");
    }

}
