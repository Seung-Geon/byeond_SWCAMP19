package com.ohgiraffers.section02.package_and_import;

import com.ohgiraffers.section01.method.Calculator;

import java.sql.Date;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 패키지에 대해 이해할 수 있다. */
        /* 설명.
         *  패키지의 의미
         *  1. 클래스의 소속
         *  2. 원래는 클래스명의 일부분
         *  3. 경우에 따라 생략 가능(import가 되었거나 같은 패키지의 클래스일 경우)
        * */
        com.ohgiraffers.section01.method.Calculator cal =
                new com.ohgiraffers.section01.method.Calculator();

        /* 설명. import를 활용하면 다른 패키지의 클래스도 줄여쓸 수 있다. */
        Calculator cal2 = new Calculator();

        System.out.println("cal의 합계: " + cal.plusTwoNumbers(100, 10));
        System.out.println("cal2의 합계: " + cal2.plusTwoNumbers(100, 10));
        System.out.println("static 메소드도 호출: " + Calculator.maxTwoNumbers(20, 10));

        /* 설명. Date형을 통한 패키지 구분 확인 */
        java.util.Date utilDate = new java.util.Date(0L);
//        java.sql.Date sqlDate = new java.sql.Date(0L);
        Date sqlDate = new Date(0L);
    }
}
