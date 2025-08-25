package com.ohgiraffers.section04.interfacesegregation.problem;

/* 설명.
 *  인터페이스 분리 원칙(Interface Segregation Principle) - "쓸데없는 규약은 싫어!"
 *  - 자신이 사용하지 않는 메소드에 의존하지 않아야 한다.
 *    (인터페이스가 너무 많은 규약을 가지면 안된다.)
* */
public class Application {
    public static void main(String[] args) {
        BadOldMachine oldPrinter = new BadOldPrinter();
        oldPrinter.print();
        oldPrinter.fax();       // 실제로 지원하지 않는 기능1
        oldPrinter.scan();      // 실제로 지원하지 않는 기능2
    }
}
