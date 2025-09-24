package com.ohgiraffers.userservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestLoginDTO {
    private String email;
    private String pwd;

}
