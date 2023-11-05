package com.example.webproject.service.impl;

import com.example.webproject.entity.Member;
import com.example.webproject.repository.MemberRepository;
import com.example.webproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
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
    public Member saveMember(Member member) {
        Member saveMember = memberRepository.save(member);
        System.out.println(saveMember);
        return saveMember;
    }

    @Override
    public Member changMember(String id, Member newmember) {
        Optional<Member> oldMember = memberRepository.findById(id);
        Member newMember;
        if(oldMember.isPresent()) {
            newMember = oldMember.get();
            newMember.setAddress(newmember.getAddress());
            newMember.setPhone(newmember.getPhone());
            newMember.setEmail(newmember.getEmail());
        } else {
            throw new EntityNotFoundException();
        }
        return newMember;
    }
    @Override
    public Member changPassword(String id, String password) {
        Optional<Member> oldMember = memberRepository.findById(id);
        Member newMember;
        if(oldMember.isPresent()) {
            newMember = oldMember.get();
            newMember.setMemberPassword(password);
        } else {
            throw new EntityNotFoundException();
        }
        return newMember;
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
