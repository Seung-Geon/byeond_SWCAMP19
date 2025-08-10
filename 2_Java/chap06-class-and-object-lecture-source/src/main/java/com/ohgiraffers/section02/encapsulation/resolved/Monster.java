package com.ohgiraffers.section02.encapsulation.resolved;

// 모듈화가 잘 되었다.
// 직접 접근을 막음
// 메소드를 통해서 수정하게 하면 이점이 많다.

public class Monster {
    private String name;        // private을 통해 클래스 외부에서 접근 불가(직접 접근을 막고, 우회로를 준다.) -> 캡슐과 같다. -> encapsulation이라 함
    private int hp;

    public void setInfo1(String innfo1){
        this.name = innfo1;
    }
    public void setInfo2(int innfo2){
        this.hp = innfo2;
    }

    public String getInfo() {
        return this.name + "의 hp는 " + this.hp;
    }
}