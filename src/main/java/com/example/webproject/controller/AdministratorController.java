package com.example.webproject.controller;

import com.example.webproject.service.AnnouncementService;
import com.example.webproject.service.BookService;
import com.example.webproject.service.LoanService;
import com.example.webproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin")
public class AdministratorController {
    private final BookService bookService;
    private final MemberService memberService;
    private final LoanService loanService;
    private final AnnouncementService announcementService;
    @Autowired
    public AdministratorController(BookService bookService, MemberService memberService, LoanService loanService, AnnouncementService announcementService) {
        this.bookService = bookService;
        this.memberService = memberService;
        this.loanService = loanService;
        this.announcementService = announcementService;
    }

    @GetMapping("Administrator")
    public String administratorView(Model model) {
        Long loanCount = loanService.getCountLoan();
        Long memberCount = memberService.getMemberCount();
        Long bookCount = bookService.getCountBook();
        model.addAttribute("loanCount", loanCount);
        model.addAttribute("memberCount", memberCount);
        model.addAttribute("bookCount", bookCount);

        return "view/Admin/AdministratorPage";
    }
}
