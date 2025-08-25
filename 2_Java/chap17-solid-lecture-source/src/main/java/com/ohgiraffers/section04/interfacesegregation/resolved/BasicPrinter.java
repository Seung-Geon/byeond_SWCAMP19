package com.ohgiraffers.section04.interfacesegregation.resolved;

public class BasicPrinter implements PrintOnly {
    @Override
    public void print() {
        System.out.println("문서를 깔끔하게 출력합니다.");
    }
}
