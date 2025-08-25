package com.ohgiraffers.assertions.section01.jupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JupiterAssertionsTest {

    /* 수업목표. JUnit5에서 제공하는 Assertions 메소드에 대해 이해하고 활용할 수 있다. */
    /* 설명. 1. assertEquals: 동등한지 비교해 주는 연산자로 참조 자료형끼리 비교할 경우에는 e(equals),h(hashCode)를 오버라이딩 할 것 */
    @Test
    public void testAssertEquals() {

        // given: 테스트를 하기 위한 준비물
        int firstNum = 10;
        int secondNum = 20;
        int expected = 31;

        // when: given을 대상에 적용
        Calculator calculator = new Calculator();
        int actual = calculator.plusTwoNumbers(firstNum, secondNum);  // 실제 대상의 값 확인

        // then: 그 결과를 판단
//        Assertions.assertEquals(expected, actual);
//        Assertions.assertEquals(expected, actual, 1);   // 1만 큼의 오차 범위 허용
        Assertions.assertEquals(expected, actual, "이건 정확해야 해!");   // 에러 발생시 띄울 메시지 지정 가능
    }

    /* 설명. 2. assertNotEquals */
    @Test
    @DisplayName("인스턴스 동일성 비교 테스트")
    public void testAssertNotEquals() {

        //given
        Object obj1 = new Object();

        //when
        Object obj2 = new Object();

        //then
        Assertions.assertNotEquals(obj1, obj2);

        /* 설명. Object는 e(equals), h(hashCode)가 동일 비교로 작성되어 있다. */
    }

    /* 설명. 3. assertNull */
    @Test
    @DisplayName("Null 인지 확인")
    void testAssertNull() {
        String str;
        str = null;
        Assertions.assertNull(str);
    }

    /* 설명. 4. assertNotNull */
    @Test
    @DisplayName("Null 아닌지 확인")
    void testAssertNotNull() {
        String str;
        str = "java";
        Assertions.assertNotNull(str);
    }

    /* 설명. 5. assertAll */
    @Test
    @DisplayName("하나의 테스트 케이스에 대해 여러 검증을 한번에 수행하는 경우 테스트")
    void asserTestAll() {

        //given
        String firstName = "길동";
        String lastName = "홍";

        // when
        Person person = new Person(firstName, lastName);

        // then
        Assertions.assertAll(
                "그룹화된 테스트 이름(테스트 실패 시 보여짐)",
                () -> Assertions.assertEquals(firstName + "1", person.getFirstName(), () -> "firstName이 잘못됨"),
                () -> Assertions.assertEquals(lastName, person.getLastName(), () -> "lastName이 잘못됨")
        );
    }


    /* 설명. 6. assertThrows */
    

}


/*
 * given, when, then의 구조로 작성
 * given: 테스트를 진행할 파라미터 값 준비
 * when: given 에서 준비한 값을 테스트할 대상에 넣어서 값 얻기
 * then: when 에서 나온 결과가 정상적으로 나왔는지 확인
* */