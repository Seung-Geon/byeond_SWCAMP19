package com.ohgiraffers.section02.lifecycle;

import org.junit.jupiter.api.*;

public class LifeCycleAnnotationTest {

    /* 설명.
     *  - 모든 테스트 메소드와 라이프사이클 관련 메소드는 abstract이면 안되고, void 반환형으로 작성해야 한다.
     *  - 접근 제어자는 사용해도 되지만(default), private이면 안된다.
     *  - BeforeAll과 AfterAll은 static이어야 한다.
    * */
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    /* 설명. 각각의 테스트 메소드가 실행되기 전에 목업 데이터(mock up, 가짜 데이터)를 미리 세팅해 줄 목적으로 사용 */
    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    /* 설명. 각각의 테스트 메소드가 동작한 이후 사용한 자원을 반납/해제할 목적으로 사용된다. */
    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }
}
