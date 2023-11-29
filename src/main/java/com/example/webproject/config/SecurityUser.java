package com.example.webproject.config;


import com.example.webproject.entity.Member;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {
    private static final long serialVersionUID = 1L;
    public SecurityUser(Member member) {
        super(member.getMemberId(), member.getMemberPassword(),
                AuthorityUtils.createAuthorityList(member.getRole().toString()));
        System.out.println(member.getMemberId());
    }
}