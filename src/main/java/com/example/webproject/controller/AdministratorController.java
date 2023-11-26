package com.example.webproject.controller;

import com.example.webproject.service.BookService;
import com.example.webproject.service.LoanService;
import com.example.webproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Administrator")
public class AdministratorController {
    private final BookService bookService;
    private final MemberService memberService;
    private final LoanService loanService;
    @Autowired
    public AdministratorController(BookService bookService, MemberService memberService, LoanService loanService) {
        this.bookService = bookService;
        this.memberService = memberService;
        this.loanService = loanService;
    }

    @GetMapping()
    public String administratorView(Model model) {
        return "view/AdministratorPage";
    }
    @PostMapping()
    public String administrator(Model model) {
        Long bookCount = bookService.getCountBook();
        model.addAttribute("bookCount", bookCount);
        Long loanCount = loanService.getCountLoan();
        model.addAttribute("loanCount", loanCount);
        Long memberCount = memberService.getMemberCount();
        model.addAttribute("memberCount", memberCount);
        return "view/AdministratorPage";
    }
}
