package com.example.webproject.controller;

import com.example.webproject.entity.Book;
import com.example.webproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookSearchController {

    @Autowired
    BookService bookService;
    @GetMapping("/search")
    public String search(Model model) {
        List<Book> bookList =  bookService.getBookList();
        Long bookCount = bookService.getCountBook();
        model.addAttribute("bookList", bookList);
        model.addAttribute("bookCount", bookCount);
        return "view/searchpage";
    }
}
