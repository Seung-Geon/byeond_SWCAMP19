package com.ohgiraffers.transactional.section01.annotation;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/* 설명. 주문한 시간 및 사용자의 주문건을 포함한 DTO(controller-service-dao 사이에서 쓸 수 있게 만든) */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
    private LocalDate orderDate;    // 서버의 현재 날짜
    private LocalTime orderTime;    // 서버의 현재 시간

    private List<OrderMenuDTO> orderMenus;  // 한건의 주문에 고객이 주문한 메뉴들
}
