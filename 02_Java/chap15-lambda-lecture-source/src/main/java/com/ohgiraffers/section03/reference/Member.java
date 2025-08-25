package com.ohgiraffers.section03.reference;

public class Member {
    private String memId;

    public Member() {
    }

    public Member(String memId) {
        System.out.println(memId + "가 넘어온 생성자 사용함...");
        this.memId = memId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memId='" + memId + '\'' +
                '}';
    }
}
