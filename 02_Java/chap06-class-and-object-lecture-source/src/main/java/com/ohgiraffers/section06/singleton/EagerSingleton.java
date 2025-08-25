package com.ohgiraffers.section06.singleton;

public class EagerSingleton {
    //이른, 빨리 만들어지는 객체
    //특징: 기본 생성자로 생성X

    private static EagerSingleton eager = new EagerSingleton();

    private EagerSingleton() {}     // 새로 객체를 만들지 못하게 객체의 생성자를 private로 만든다.

    public static EagerSingleton getInstance() {
        return eager;
    }

}
