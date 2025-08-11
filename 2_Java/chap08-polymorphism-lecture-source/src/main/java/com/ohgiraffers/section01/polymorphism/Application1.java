package com.ohgiraffers.section01.polymorphism;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 다형성과 타입 형변환에 대해 이해할 수 있다. */
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.cry();

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite();

        Rabbit rabbit = new Rabbit();
        rabbit.eat();
        rabbit.run();
        rabbit.cry();
        rabbit.jump();


        Animal an1 = new Animal();  // 다형성 적용 X
        Animal an2 = new Tiger();   // 다형성 적용 O 자동 형변환(부모 타입으로의 upcasting)
        Animal an3 = new Rabbit();  // 다형성 적용 O 자동 형변환(부모 타입으로의 upcasting)

        Object obj = new Animal();  // 다형성 적용 O

        /* 설명. Animal은 Tiger 또는 Rabbit 타입이 아니다. */
        //Tiger tr = new Animal();
    }
}
