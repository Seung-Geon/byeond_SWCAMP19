package com.ohgiraffers.section05.dependencyinversion.problem;

public class BadSMSSender {

    public void senSMS(String message) {
        System.out.println("문자 발송: " + message);
    }
}
