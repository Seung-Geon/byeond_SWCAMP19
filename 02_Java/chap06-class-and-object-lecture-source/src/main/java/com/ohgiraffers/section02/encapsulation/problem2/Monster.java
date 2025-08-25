package com.ohgiraffers.section02.encapsulation.problem2;

// 모듈화가 잘 되었다.
// 직접 접근을 막음
// 메소드를 통해서 수정하게 하면 이점이 많다.

public class Monster {
    public String name;
    int hp;
    //int mp;

    // hp를 주석처리해도 main 에서는 오류가 안난다.
    // hiding(은닉화) 기술: 두번째 필드를 숨겨서 직접 접근을 막는다.
    // 중간에 인터페이스(중매자)를 사용해 결합도를 낮춤
    public void setInfo(int info2) {
        this.hp = info2;
    }
}