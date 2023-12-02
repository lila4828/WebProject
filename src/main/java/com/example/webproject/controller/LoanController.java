package com.example.webproject.controller;

import com.example.webproject.dto.BookDto;
import com.example.webproject.dto.LoanDto;
import com.example.webproject.entity.Book;
import com.example.webproject.entity.Loan;
import com.example.webproject.service.BookService;
import com.example.webproject.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/LoanList")
public class LoanController {

    private final LoanService loanService;
    private final BookService bookService;

    @Autowired
    public LoanController(LoanService loanService, BookService bookService) {
        this.loanService = loanService;
        this.bookService = bookService;
    }

    @GetMapping()
    public String LoanView(Model model) {
        model.addAttribute("searchName", "");

        return "view/Loan/SearchPage";
    }

    @GetMapping("/Search")
    public String BookSearchView(@RequestParam("searchName") String searchName,
                                 Model model)
    {
        List<Book> bookList;
        List<BookDto> bookDtoList = new ArrayList<>();

        bookList = bookService.getBookName(searchName);

        for(Book book : bookList) {
            BookDto bookDto = new BookDto(book);
            bookDtoList.add(bookDto);
        }

        model.addAttribute("searchName", searchName);
        model.addAttribute("bookList", bookDtoList);

        return "view/Loan/BookLoan";
    }

    @GetMapping("{bookIsbn}")
    public String BookLoan(@PathVariable Long bookIsbn, Model model) {
        Book book = bookService.getBook(bookIsbn);

        model.addAttribute("Loan", new LoanDto());
        model.addAttribute("book", book);
        model.addAttribute("date", "");

        return "view/Loan/LoanAdd";
    }

    @PostMapping("/LoanAdd/{bookIsbn}")
    public String LoanAdd(@PathVariable String bookIsbn,
                          @RequestParam("date") String date)
    {


        Book book = bookService.getBook((long) Integer.parseInt(bookIsbn));

        Loan loan = new Loan();
        loan.setDateLoan(date);
        loan.setNumberExtensions(0L);
        loan.setIsbn(book);

        // 구현 중 - 멤버 아이디를 어떻게 가져올지 모름
        /*Member member = memberService.getMember(boardDto.getMemberId());
        if(member == null) {
            return "redirect:/error";
        }
        loan.setMemberID(member);*/

        loanService.bookLoan(loan);

        return "redirect:/LoanList";
    }

    @GetMapping("/LoanReturn")
    public String LoanReturnView(Model model) {
        List<Loan> loanList = loanService.getLoanList();
        model.addAttribute("LoanList", loanList);

        return "view/Loan/LoanView";
    }

    @GetMapping("/LoanReturn/{id}")
    public String LoanReturn(@PathVariable("id") Long LoanId) {
        loanService.returnLoan(LoanId, LocalDate.now());

        return "view/Loan/LoanReturn";
    }

    // 대출 연장
    @GetMapping("/LoanReturn/Extensions/{id}")
    public String LoanExtensionView(@PathVariable("id") Long LoanId,
                                    Model model)
    {
        loanService.extendLoan(LoanId);
        Loan loan = loanService.getLoanId(LoanId);

        LoanDto loanDto = new LoanDto(loan);
        model.addAttribute("Loan", loanDto);

        return "view/Loan/LoanExtensionsView";
    }

}
