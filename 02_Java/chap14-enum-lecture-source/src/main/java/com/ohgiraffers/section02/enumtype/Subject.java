package com.ohgiraffers.section02.enumtype;

public enum Subject {
    JAVA,   // 하나의 객체, singleton으로 관리
    MARIADB,
    JDBC,
    HTML,
    CSS,
    JAVASCRIPT; // enum 타입에 추가적인 코드가 있을 경우 ;을 빼먹으면 안됨

    Subject() {
        System.out.println("기본 생성자 호출됨...");
    } // 필드 개수만큼 호출됨, lazy-singleton

    @Override
    public String toString() {
        return "@@@" + this.name();
    }
}
