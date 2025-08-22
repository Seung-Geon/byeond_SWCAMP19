package com.ohgiraffers.section1.singleresponsibility.problem;


/* 설명.
 *  단일 책임의 원칙(Single Responsibility Principle, SRP) - "클래스의 책임이 너무 많거나 노출되면 안됨"
 *  - 한 클래스는 하나의 책임만 가져야 된다. -> 하나의 기능에 문제가 생겨서 객체를 사용 못하게 되면 나머지 기능도 사용을 못함
 *  - 클래스가 변경되어야 하는 이유는 오직 하나여야 한다.
 *  - 캡슐화를 통해 클래스의 책임을 명확히 하고 구현 세부사항을 숨긴다.
* */
public class Application {
    public static void main(String[] args) {

        /* 설명. 하나의 객체가 여러 책임을 가진다. -> 하나의 기능에 문제가 생긴다. -> 객체 생성이 안되기 때문에 나머지 기능도 사용 못함 */
        BadEmployee badEmp = new BadEmployee();
        badEmp.saveEmployee();          // 사원 정보 DB 저장
        badEmp.reportWorkingHours();    // 근무시간 보고
        badEmp.applyPayRate();          // 직원의 급여 계산


    }
}
