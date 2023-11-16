package com.example.webproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainView() {
        return "view/homePage";
    }

    @GetMapping("/error")
    public String errorView() { return "view/errorPage";}
}
