package com.ohgiraffers.section03.grammer;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.EnumSet;
import java.util.Iterator;

public class Application {
    public static void main(String[] args) {

        UserRole1 admin = UserRole1.ADMIN;
        System.out.println(admin.name());
        System.out.println(admin.getNameToLowerCase());

        UserRole2 consumer = UserRole2.CONSUMER;
        System.out.println(consumer.ordinal() + ", " + consumer.name() + ", " + consumer.getDESCRIPTION());

        /* 설명. Set의 개념으로도 활용할 수 있다.(feat. Iterator) */
        System.out.println("Set으로 바꿔 활용하기");
        EnumSet<UserRole2> roles = EnumSet.allOf(UserRole2.class);
        Iterator<UserRole2> iter = roles.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
