package com.ohgiraffers.listener.section02.sessionlistener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

import java.util.Objects;

public class UserDTO implements HttpSessionBindingListener {
    private String name;
    private int age;

    public UserDTO() {
    }

    public UserDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return age == userDTO.age && Objects.equals(name, userDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    /* 설명. HttpSessionBindingListener는 각 class 마다 별도로 작성 */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
//        HttpSessionBindingListener.super.valueBound(event);
        System.out.println("UserDTO 객체가 session에 담김");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
//        HttpSessionBindingListener.super.valueUnbound(event);
        System.out.println("UserDTO 객체가 session에서 제거됨");
    }
}
