package com.ohgiraffers.common;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/* 설명. add 라는 메소드로 직접 상품을 담을 예정(feat. 의존성 주입 X) */
@ToString
public class ShoppingCart {
    private final List<Product> items;  // 하나의 collection을 사용한다는 것이지 내부의 상품은 변경될 수 있다.
    // NPE 방지를 위한 final
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    /* 설명. 카트에 물품을 담는 기능 */
    public void addItem(Product item) {
        this.items.add(item);
    }

    /* 설명. 카트에 물품을 꺼내는 기능(한번에 다 꺼내기) */
    public List<Product> getItems() {
        return items;
    }



}


