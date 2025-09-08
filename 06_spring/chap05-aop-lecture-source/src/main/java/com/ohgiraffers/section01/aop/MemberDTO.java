package com.ohgiraffers.section01.aop;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    private Long id;        // 많은 때 래퍼 클래스 Long을 사용 - java에서는 null이 들어갈 수 있다 싶으면 래퍼클래스 사용
    private String name;
}
