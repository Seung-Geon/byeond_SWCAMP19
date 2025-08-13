package com.ohgiraffers.section03.stringbuilder;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. StringBuilder의 자주 사용되는 메소드의 용법 및 원리를 이해할 수 있다. */
        //StringBuilder sb = new StringBuilder("javamariaDB");
        StringBuffer sb = new StringBuffer("javamariaDB");

        /* 설명. delete() */
        System.out.println("delete(): " + sb.delete(2,5)); // 2번 인덱스부터 5번 인덱스 까지 삭제


        /* 설명. deleteCharAt() */
        System.out.println("delete(): " + sb.deleteCharAt(2)); // 지정 인덱스 삭제

        /* 설명. insert() */
        System.out.println("insert(): " + sb.insert(1,"vao"));  // 지정 인덱스에 str을 삽입
        System.out.println("insert(): " + sb.insert(0,"j"));
        System.out.println("insert(): " + sb.insert(sb.length(),"jdbc")); // sb.length()를 통해서 마지막 문자열에 삽입

        /* 설명. reverse() */
        System.out.println("reverse(): " + sb.reverse());   // 문자열 뒤집기

    }
}
