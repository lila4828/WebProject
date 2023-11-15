package com.example.webproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {   
    private String memberId;        // 멤버 아이디
    private String memberPassword;  // 멤버 비번
    private String address;         // 주소
    private String phone;           // 핸드폰
    private String email;           // 이메일
}
