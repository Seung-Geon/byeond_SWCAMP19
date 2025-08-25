package com.ohgiraffers.section02.abstractclass;

public class Phone extends Product {

    public Phone() {
        super();
    }

    @Override
    public void abstractMethod(){
        System.out.println("안빼먹고 오버라딩 잘 했다잉!~");
    }
}
