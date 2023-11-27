package com.example.webproject;

import com.example.webproject.entity.Member;
import com.example.webproject.entity.Role;
import com.example.webproject.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("Member 데이터 생성")
    void save() {

        // admin 계정
        // given
        Member admin = new Member();
        admin.setMemberId("admin");
        admin.setRole(Role.ADMIN);
        admin.setMemberPassword(passwordEncoder.encode("1234"));

        // when
        Member savedMember1 = memberRepository.save(admin);
        // then
        assertEquals(admin.getMemberId(), savedMember1.getMemberId());


        //member 계정
        Member member = new Member();
        member.setMemberId("member");
        member.setRole(Role.MEMBER);
        member.setMemberPassword(passwordEncoder.encode("1234"));

        Member savedMember2 = memberRepository.save(member);

        assertEquals(member.getMemberId(), savedMember2.getMemberId());

    }
}

