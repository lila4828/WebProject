package com.example.webproject.controller;

import com.example.webproject.entity.Book;
import com.example.webproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class BookSearchController {

    @Autowired
    BookService bookService;
    @GetMapping("/Search")
    public String GoSearch(Model model) {

        return "view/searchPage";
    }
    /*@PostMapping("/search/{bookname}")
    public String Search(@PathVariable("bookname") String bookname, Model model) {
        List<Book> bookList = null;

        Long bookCount = bookService.getCountBook();
        model.addAttribute("bookList", bookList);
        model.addAttribute("bookCount", bookCount);
        return "searchPage";
    }*/
}
