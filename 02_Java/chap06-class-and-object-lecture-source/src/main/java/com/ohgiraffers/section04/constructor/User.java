package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class User {
    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    /* 설명. 기본 생성자(작성하지 않아도 작성된, 명시적으로 작성하는 걸 권장) */
    public User() {
        System.out.println("기본생성자 실행됨...");
    }
    // 생성자의 매개변수의 갯수, 타입, 순서가 다르면 다르게 봐서 여러 생성자를 만들 수 있다.
    /* 설명. 매개변수 있는 생성자(객체가 생성할 때 초기화 하고 싶은 값을 매개변수로 가지는 생성자) */
    /* 설명. 생성자에서 this.의 의미는 해당 생성자로 생성 될 객체를 뜻함 */
    public User(String id, String pwd, String name) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    // alt + insert 단축키로 간단하게 생성자 생성 가능
    public User(String id, String pwd, String name, Date enrollDate) {
        /* 설명. this()는 같은 클래스의 다른 생성자를 참조할 때 사용
         *  1. 첫 줄에 사용할 것
         *  2. 다른 생성자 하나만 추가 사용 가능
         *  (목적은 코드 줄 수 줄이기)
        *  */

//        this.id = id;
//        this.pwd = pwd;
//        this.name = name;
//        this.enrollDate = enrollDate;
        this(id, pwd, name);
        this.enrollDate = enrollDate;
    }

    public String getInfo() {
        return this.id + "," + this.pwd + "," + this.name + "," + this.enrollDate;
    }

}

/*
* 오버로딩: 같은 이름의 메소드 활용
* 같은 이름을 못쓴다면 예를 들어 println에 들어오는 자료형마다 다른 메소드 이름으로 만들어줘서 구분해서 사용해야 함
* 이를 오버로딩을 통해 이름은 동일하되 기능이 다른 함수를 만들어서 사용
* */