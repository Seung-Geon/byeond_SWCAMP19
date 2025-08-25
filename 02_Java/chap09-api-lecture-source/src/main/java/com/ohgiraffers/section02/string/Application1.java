package com.ohgiraffers.section02.string;

import org.w3c.dom.ls.LSOutput;

public class Application1 {
    public static void main(String[] args) {

        /* 설명. 문자열 객체를 생성하는 다양한 방법을 숙지하고 문자열 인스턴스가 생성되는 방식을 이해할 수 있다. */
        /* 설명.
         *  문자열을(객체를) 만드는 방법
         *   1. "" 리터럴 형태: 동일한 값을 가지는 문자열 인스턴스(동등(e, h))를 단일 인스턴스로 관리
         *                    (일종의 singleton 개념, heap의 상수풀(constant pool) 활용)
         *   2. new String(""): 매번 새로운 인스턴스를 heap 영역에 생성
         * */

        String str1 = "java";
        String str2 = "java";
        String str3 = new String("java");
        String str4 = new String("java");

        System.out.println("str1 == str2: " + (str1 == str2));  // 리터럴 형태일 때는 같은 객체는 한번만 만들어 진다
        System.out.println("str2 == str3: " + (str2 == str3));  //
        System.out.println("str3 == str4: " + (str3 == str4));

        System.out.println("str1의 주소: " + System.identityHashCode(str1));
        System.out.println("str2의 주소: " + System.identityHashCode(str2));
    }
}
