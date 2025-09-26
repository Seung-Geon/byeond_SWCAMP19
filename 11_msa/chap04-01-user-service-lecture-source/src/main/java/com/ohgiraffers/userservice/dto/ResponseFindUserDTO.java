package com.ohgiraffers.userservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseFindUserDTO {
    private String email;
    private String name;
    private String userId;

    List<ResponseOrderDTO> orders;

}
