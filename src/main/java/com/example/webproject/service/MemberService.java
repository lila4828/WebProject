package com.example.webproject.service;

import com.example.webproject.entity.Member;

public interface MemberService {
    public Member getMember(String id); // 회원 가져오기

    public Member saveMember(Member member);    // 회원가입

    public Member changMember(String id, Member newmember); // 회원 주소, 폰, Email 수정

    public Member changPassword(String id, String newpassword); // 회원 패스워드 변경

    public void deleteMember(String id);    // 회원 탈퇴
}
