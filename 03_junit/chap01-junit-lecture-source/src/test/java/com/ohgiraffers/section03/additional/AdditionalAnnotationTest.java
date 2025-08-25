package com.ohgiraffers.section03.additional;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)   // 테스트 케이스 우선 순위 부여를 위한 사전 준비
public class AdditionalAnnotationTest {

    /* 수업목표. JUnit에서 제공하는 메소드 관련 추가 어노테이션을 사용할 수 있다. */
    @Test
    @Disabled       // 테스트 케이스 생략 시
    public void testIgnore() {}

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)    // 타임 아웃 체크 시
    public void testTimeout() throws InterruptedException {
        Thread.sleep(900);  // 0.9초 시간 지연 발생
    }

    /* 설명. 테스트 클래스에 @TestMethodOrder 어노테이션을 추가해서 낮은 숫자가 먼저 동작하게 테스트 코드 작성 */
    @Test
    @Order(1)   // 우선순위 부여(낮은 숫자를 먼저 실행)
    public void testFirst() {}

    @Test
    @Order(3)
    public void testThird() {}

    @Test
    @Order(2)
    public void testSecond() {}


}
