package com.example.webproject.service.impl;

import com.example.webproject.dto.MemberDto;
import com.example.webproject.entity.Member;
import com.example.webproject.repository.MemberRepository;
import com.example.webproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getMemberList() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMember(String id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void changeMember(String id, MemberDto memberDto) {
        Member selectMember = memberRepository.findById(id).orElse(null);

        selectMember.setAddress(memberDto.getAddress());
        selectMember.setPhone(memberDto.getPhone());
        selectMember.setEmail(memberDto.getEmail());

        memberRepository.save(selectMember);
    }
    @Override
    public void changePassword(String id, String newPassword) {
        Member selectMember = memberRepository.findById(id).orElse(null);

        selectMember.setMemberPassword(newPassword);

        memberRepository.save(selectMember);
    }

    @Override
    public void deleteMember(String id) {
        memberRepository.deleteById(id);
    }
}
