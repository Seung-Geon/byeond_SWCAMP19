package com.ohgiraffers.common;

import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class Bread extends Product{
    private java.util.Date date; // 생성 시간

    public Bread(String name, int price, Date date) {
        super(name, price);
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "date=" + date +
                "} " + super.toString();
    }
}
