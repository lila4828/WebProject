package com.example.webproject.controller;

import com.example.webproject.entity.Announcement;
import com.example.webproject.entity.Book;
import com.example.webproject.service.AnnouncementService;
import com.example.webproject.service.BookService;
import com.example.webproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {
    private final AnnouncementService announcementService;
    private final BookService bookService;

    @Autowired
    public MainController(AnnouncementService announcementService, BookService bookService) {
        this.announcementService = announcementService;
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String mainView(Model model, Principal principal) {
        List<Announcement> announcementList = announcementService.getAnnouncementList();

        if(principal != null) {
            String userId = principal.getName();
            model.addAttribute("userId", userId);
        }

        model.addAttribute("announcementList", announcementList);

        List<Book> bookList = bookService.getRecommendBookList();

        model.addAttribute("Book1", bookList.get(0));
        model.addAttribute("Book2", bookList.get(1));
        model.addAttribute("Book3", bookList.get(2));
        model.addAttribute("Book4", bookList.get(3));

        return "view/HomePage";
    }

    @GetMapping("/Login")
    public String login() { return "view/Login"; }

    @GetMapping("/Logout")
    public String logout() { return "view/Logout"; }

    @GetMapping("/Error")
    public String errorView() { return "view/ErrorPage";}

    @GetMapping("/RoleError")
    public String roleErrorView() { return "view/RoleErrorPage";}
}
