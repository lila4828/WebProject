package com.example.webproject.service;

import com.example.webproject.dto.MemberDto;
import com.example.webproject.entity.Member;

import java.util.List;

public interface MemberService {
    
    public List<Member> getMemberList();                        // 회원 리스트 가져오기
    
    public Member getMember(String id);                         // 회원정보 가져오기

    public void saveMember(Member member);                      // 회원가입

    public void changeMember(String id, MemberDto memberDto);   // 회원 주소, 폰, Email 수정

    public void changePassword(String id, String newPassword);  // 회원 패스워드 변경

    public void deleteMember(String id);                        // 회원 탈퇴

}
