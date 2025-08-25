package com.ohgiraffers.section04.Override;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        SuperClass superClass = new SubClass();
        try {
            superClass.method();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
