package com.example.webproject.controller;

import com.example.webproject.entity.Announcement;
import com.example.webproject.service.AnnouncementService;
import com.example.webproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private final AnnouncementService announcementService;
    private final MemberService memberService;

    @Autowired
    public MainController(AnnouncementService announcementService, MemberService memberService) {
        this.announcementService = announcementService;
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String mainView(Model model) {
        List<Announcement> announcementList = announcementService.getAnnouncementList();

        model.addAttribute("announcementList", announcementList);

        return "view/HomePage";
    }

    @GetMapping("/Login")
    public String login() { return "view/Login"; }

    @GetMapping("/Logout")
    public String logout() { return "view/Logout"; }

    @GetMapping("/Error")
    public String errorView() { return "view/ErrorPage";}
}
