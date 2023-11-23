package com.example.webproject.controller;

import com.example.webproject.entity.Announcement;
import com.example.webproject.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private final AnnouncementService announcementService;

    @Autowired
    public MainController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/")
    public String mainView(Model model) {
        List<Announcement> announcementList = announcementService.getAnnouncementList();

        model.addAttribute("announcementList", announcementList);

        return "view/HomePage";
    }

    @GetMapping("/error")
    public String errorView() { return "view/errorPage";}
}
