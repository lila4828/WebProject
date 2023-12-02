package com.example.webproject.controller;

import com.example.webproject.dto.MemberDto;
import com.example.webproject.entity.Member;
import com.example.webproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/MemberList")
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping()
    public String ViewList(Model model) {
        List<Member> memberList = memberService.getMemberList();

        model.addAttribute("memberList", memberList);

        return "view/Member/MemberList";
    }
    @GetMapping("viewMember/{id}")
    public String showMember(@PathVariable("id") String MemberID, Model model) {
        Member member = memberService.getMember(MemberID);

        model.addAttribute("member", member);

        return "view/Member/Memberview";
    }
    @GetMapping("/editMember/{id}")
    public String showEditMember(@PathVariable("id") String MemberId, Model model) {
        Member member = memberService.getMember(MemberId);

        model.addAttribute("member", member);

        return "view/Member/Memberview";
    }
    @PostMapping("/editMember/{id}")
    public String editMember(@PathVariable("id") String memberId, @ModelAttribute MemberDto memberDto) {
        memberService.changeMember(memberId, memberDto);

        return "redirect:/MemberList";
    }
    @GetMapping("/deleteMember/{id}")
    public String deleteMember(@PathVariable("id") String MemberId) {
        memberService.deleteMember(MemberId);
        return "redirect:/MemberList";
    }
}