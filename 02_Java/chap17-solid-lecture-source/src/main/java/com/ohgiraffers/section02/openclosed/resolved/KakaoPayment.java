package com.ohgiraffers.section02.openclosed.resolved;

public class KakaoPayment implements Payment {
    @Override
    public void process() {
        System.out.println("카카오 페이로 결제 처리");
    }
}
