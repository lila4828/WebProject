package com.example.webproject.service.impl;

import com.example.webproject.dto.MemberDto;
import com.example.webproject.entity.Member;
import com.example.webproject.repository.MemberRepository;
import com.example.webproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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
        Optional<Member> member = memberRepository.findById(id);
        if(member.isPresent()) {
            return member.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Member saveMember(MemberDto memberDto) {
        Member saveMember = new Member();
        saveMember.setMemberId(memberDto.getMemberId());
        saveMember.setMemberPassword(memberDto.getMemberPassword());
        saveMember.setAddress(memberDto.getAddress());
        saveMember.setPhone(memberDto.getPhone());
        saveMember.setEmail(memberDto.getEmail());

        memberRepository.save(saveMember);
        return saveMember;
    }

    @Override
    public void changeMember(String id, MemberDto memberDto) {
        Optional<Member> oldMember = memberRepository.findById(id);
        if(oldMember.isPresent()) {
            Member newMember = oldMember.get();
            newMember.setAddress(memberDto.getAddress());
            newMember.setPhone(memberDto.getPhone());
            newMember.setEmail(memberDto.getEmail());

            memberRepository.save(newMember);
        } else {
            throw new EntityNotFoundException();
        }
    }
    @Override
    public void changePassword(String id, String newPassword) {
        Optional<Member> oldMember = memberRepository.findById(id);
        if(oldMember.isPresent()) {
            Member newMember = oldMember.get();
            newMember.setMemberPassword(newPassword);

            memberRepository.save(newMember);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void deleteMember(String id) {
        Optional<Member> selectMember = memberRepository.findById(id);
        if(selectMember.isPresent()) {
            Member member = selectMember.get();
            memberRepository.delete(member);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
