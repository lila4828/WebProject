package com.example.webproject.controller;

import com.example.webproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String loginView() { return "view/loginpage"; }
}
