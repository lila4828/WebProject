package com.example.webproject.controller;

import com.example.webproject.dto.BookDto;
import com.example.webproject.dto.MemberDto;
import com.example.webproject.entity.Book;
import com.example.webproject.entity.Member;
import com.example.webproject.entity.Role;
import com.example.webproject.entity.Tag;
import com.example.webproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/Admin")
public class AdministratorController {
    private final BookService bookService;
    private final MemberService memberService;
    private final LoanService loanService;
    private final AnnouncementService announcementService;
    private final TagService tagService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AdministratorController(BookService bookService, MemberService memberService, LoanService loanService, AnnouncementService announcementService, TagService tagService) {
        this.bookService = bookService;
        this.memberService = memberService;
        this.loanService = loanService;
        this.announcementService = announcementService;
        this.tagService = tagService;
    }

    @GetMapping()
    public String administratorView(Model model) {
        Long loanCount = loanService.getCountLoan();
        Long memberCount = memberService.getMemberCount();
        Long bookCount = bookService.getCountBook();
        model.addAttribute("loanCount", loanCount);
        model.addAttribute("memberCount", memberCount);
        model.addAttribute("bookCount", bookCount);

        return "view/Admin/AdministratorPage";
    }

    @GetMapping("/BookAdd")
    public String bookAdd(Model mode) {
        mode.addAttribute("Book", new BookDto());
        return "view/BookAdd";
    }

    @PostMapping("/BookAdd")
    public String bookAdd(@ModelAttribute BookDto bookDto, Model model) {
        Book newBook = new Book();

        newBook.setIsbn(bookDto.getIsbn());
        newBook.setBookName(bookDto.getBookName());
        newBook.setAuthor(bookDto.getAuthor());
        newBook.setYear(bookDto.getYear());
        newBook.setLoanAvailability(true);
        newBook.setNewBookAvailability(true);
        newBook.setNumberLoan(0L);

        Tag tag = tagService.getTagByName(bookDto.getTag());
        if(tag==null) {
            Tag newTag = new Tag();
            newTag.setTag(bookDto.getTag());
            tagService.saveTag(newTag);
            newBook.setTag(newTag);
        }
        else {
            newBook.setTag(tag);
        }
        newBook.setImageUrl("");

        bookService.saveBook(newBook);
        model.addAttribute("Book", newBook);
        return "view/BookView";
    }

    @GetMapping("/AddAdmin")
    public String addAdmin(Model model) {
        model.addAttribute("Admin", new MemberDto());
        return "view/Admin/AdminAdd";
    }
    @PostMapping("/AddAdmin")
    public String addAdmin(@ModelAttribute MemberDto memberDto) {
        Member newAdmin = new Member();

        newAdmin.setMemberId(memberDto.getMemberId());
        newAdmin.setMemberPassword(passwordEncoder.encode(memberDto.getMemberPassword()));
        newAdmin.setAddress(memberDto.getAddress());
        newAdmin.setPhone(memberDto.getPhone());
        newAdmin.setEmail(memberDto.getEmail());
        newAdmin.setRole(Role.ADMIN);

        memberService.saveMember(newAdmin);
        return "view/Admin/AdminSuccess";
    }

    @GetMapping("/ChangePassword")
    public String showChangePassword(Model model) {

        model.addAttribute("newPassword", "");

        return "view/Admin/PasswordChange";
    }

    @PostMapping("/ChangePassword")
    public String changePassword(@RequestParam("newPassword") String password,
                                 Principal principal) {

        memberService.changePassword(principal.getName(), password);

        return "redirect:/Admin";
    }
}
