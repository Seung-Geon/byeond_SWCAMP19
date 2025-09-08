package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        System.out.println("==== 회원 전체 조회 ====");
        MemberService memberService = context.getBean("memberService",  MemberService.class);
        memberService.findAllMembers().forEach(System.out::println);

        System.out.println("==== 회원 한명 조회 ====");
        System.out.print(memberService.findMemberBy(1));

        /* 설명. AfterThrowing Advice 확인용 요청 */
//        System.out.println("==== 범위를 벗어난 조회 ====");
//        System.out.print(memberService.findMemberBy(3));      // after returning 시 추가된
//                                                                    // MemberDTO 객체가 있어 3으로 테스트
    }
}
