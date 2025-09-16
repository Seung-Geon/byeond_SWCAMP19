package com.ohgiraffers.transactional.section01.annotation;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderMenu {
    private int orderCode;
    private int menuCode;
    private int orderAmount;

}
