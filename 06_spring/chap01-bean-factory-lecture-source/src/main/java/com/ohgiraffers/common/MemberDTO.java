package com.ohgiraffers.common;

import lombok.*;

//@NoArgsConstructor  // 기본 생성저
@AllArgsConstructor // 모든 속성을 넣은 생성자
//@Setter             // getter 자동 생성
//@Getter             // setter 자동 생성
//@ToString           // toString 자동 생성
@Data               // equals, hashcode까지다 만들어주는 <- 권장X 배포 단계에서는 위에것으로 바꿔줘야 함 필요한 것만 들어가게, 개발단계에서 사용
public class MemberDTO {
    private int sequence;
    private String id;
    private String pwd;
    private String name;


}
