package com.ohgiraffers.section01.test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/* 설명. 테스트 클래스들은 클래스명 긑이 'Test/Tests'를 붙여 작성한다. */
public class TestAnnotationTest {


    /* 수업목표. JUnit5의 기본 어노테이션을 사용할 수 있다. */
    /* 설명.
     *  테스트 케이스: 테스트 대상이 되는 기능에 대해 시나리오별로 어떤 것을 테스트 하는지에 대해 정의한 것
     *               (정상 흐름/ 예외 흐름 확인)
    * */
    @Test
    @DisplayName("테스트 메소드가 통과하는지 확인")
    public void testMethod() {

    }

    @Test
    @DisplayName("어노테이션 내용이 우선순위가 높다.")
    public void 매개변수로_1과_3을_넘겼을_때_합계를_int형으로_잘_반환하는지_확인() {

    }

}
