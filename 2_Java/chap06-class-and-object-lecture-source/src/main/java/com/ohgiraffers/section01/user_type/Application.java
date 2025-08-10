package com.ohgiraffers.section01.user_type;

import java.util.Arrays;

public class Application {

    /* 설명.
     *  객체지향프로그래밍(OOP)란?
     *  OOP(Object Oriented Programming language)
     *  : 추상화, 캡슐화, 상속, 다형성을 적용하여 유지보수성을 고려한 응집력 높고 결합도 낮은
     *    객체 위주의 개발방식을 추구하는 프로그래밍을 말한다.
     *  응집력이 높다.: 한 클래스만 봐도 관련된 요소가 모여 있다. -> 유지보구하기 좋다.
     *  결합도가 낮다.: 클래스와 클래스 사이의 연결이 적다 -> 유지보수하기 좋다.
     *  !! 좋은 코드 !! : 유지보수하기 좋은 코드
     *  객체지향 프로그래밍의 4대 특징: 추상화, 캡슐화, 상속, 다형성
     *  객체지향 프로그래밍의 3대 특징: 캡슐화, 상속, 다형성
     *
     * 설명.
     *   객체지향의 특징(4대 특징)
     *   - 추상화(Abstraction) (이걸 빼면 3대 특징)
     *   - 캡슐화(Encapsulation)
     *   - 상속(Inheritance)
     *   - 다형성(Polymorphism)
    * */

    public static void main(String[] args) {

        /* 설명. 클래스 없이 여러 타입으로 여러 값을 관리할 경우 */
        /* 설명.
         *  1. 많은 변수들을 따로 관리하기 어렵다.(한 묶음으로 생각히거나 코딩할 수 없다.)
         *  2. 메소드의 전달인자로 전달할 값이 많아지므로 매개변수의 갯수가 늘어난다.
         *     (냄새나는 코드 -> 리팩토링의 징조)
         *  3. 메소드의 반환형으로는 하나의 타입만 가능하지만 클래스가 없이는 여러 속성을 반환하는 것이 불가능
        * */
        Member member1 = new Member();
        Member member2 = new Member();

        /* 설명. 사람 한명씩 접근해 이름을 부여하는 느낌의 코드 */
        member1.name = "김철수";
        member2.name = "김영희";

        /* 설명. 김영희씨만 우선 완성해 보자. */
        member2.age = 19;
        member2.gender = '여';
        member2.hobbies = new String[]{"볼링", "하비"};
        member2.id = "user02";
        member2.pwd = "pass02";

        System.out.println("김영희씨 이름과 나이를 말해주세요: \n " + member2.name + "이구요, 나이는 " + member2.age + "입니다.");

        int num = 1;
        test(member2,num);
        System.out.println("개명 이후 이름: " + member2.name);            // 얕은 복사로 member2도 변경됨 -> 굳이 반환을 받을 필요가 없음
        System.out.println("메소드를 호출할 때 넘겨준 num의 값: " + num);    // 기본 자료형이므로 변화X

        /* 설명.
         *  기본 자료형의 값을 넘길때 vs 참조 자료형의 값을 넘길 때
         *  1. 기본 자료형은 메소드를 호출한 곳이 영향을 받지X
         *  2. 참조 자료형은 메소드를 호출한 곳이 영향을 받을 수 O(feat. 반환 필요X)
        * */

    }

    private static void test(Member m, int n) {
        System.out.println("개명하고 싶어!~");
        m.name = "김용희";
        n += 10;
        System.out.println("메소드 안에서의 n의 값: " + n);
    }
}
