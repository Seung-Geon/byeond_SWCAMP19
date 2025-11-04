package com.backoven.bootproject.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor    // @NonNull이 들어간 변수들로 이루어진 생성자를 만들어준다
public class CalculatorDTO {
    @NonNull
    private Integer num1;
    @NonNull
    private Integer num2;
    private int sum = 0;
}
