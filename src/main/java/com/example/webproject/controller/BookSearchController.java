package com.example.webproject.controller;

import com.example.webproject.entity.Book;
import com.example.webproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/SearchList")
public class BookSearchController {
    private final BookService bookService;

    @Autowired
    public BookSearchController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping()
    public String GoSearch() {

        return "view/SearchPage";
    }
    @PostMapping("/{bookname}")
    public String Search(@RequestParam("bookName") Book book, Model model) {
//        List<Book> bookList = bookService.getBookName(book.getBookName(book));
//        int bookCount = 0;
//        for(Book book : bookList) {
//            bookCount++;
//        }
//        model.addAttribute("bookList", bookList);
//        model.addAttribute("bookCount", bookCount);
        return "redirect:SearchList";
    }
}
