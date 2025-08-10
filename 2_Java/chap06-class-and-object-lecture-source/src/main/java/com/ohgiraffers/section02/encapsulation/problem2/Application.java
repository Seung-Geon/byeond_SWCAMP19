package com.ohgiraffers.section02.encapsulation.problem2;

public class Application {
    public static void main(String[] args) {
        Monster m = new Monster();
        m.name = "드라큘라";
        //m.hp = 200;
        m.setInfo(200);
    }
}
