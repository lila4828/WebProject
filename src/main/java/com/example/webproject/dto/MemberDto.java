package com.example.webproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String memberId;
    private String memberPassword;
    private String address;
    private String phone;
    private String email;
}
