package com.example.webproject.controller;

import com.example.webproject.dto.BookDto;
import com.example.webproject.entity.Book;
import com.example.webproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public String GoSearch(Model model) {
        model.addAttribute("selectSearch", "");
        model.addAttribute("searchName", "");

        return "view/Search/SearchPage";
    }

    @GetMapping("/SearchBook")
    public String Search(@RequestParam("selectSearch") String selectSearch,
                         @RequestParam("searchName") String searchName,
                         Model model)
    {
        List<BookDto> bookDtoList = bookListGet(selectSearch, searchName);

        int bookCount = bookDtoList.size();

        model.addAttribute("selectSearch", selectSearch);
        model.addAttribute("searchName", searchName);
        model.addAttribute("bookList", bookDtoList);
        model.addAttribute("bookCount", bookCount);

        return "view/Search/BookSearch";
    }

    public List<BookDto> bookListGet(String selectSearch, String searchName) {

        List<Book> bookList;
        List<BookDto> bookDtoList = new ArrayList<>();

        if(selectSearch.equals("title")) {
            bookList = bookService.getBookName(searchName);
            for(Book book : bookList) {
                BookDto bookDto = new BookDto(book);
                bookDtoList.add(bookDto);
            }
        }
        else if (selectSearch.equals("tag")) {
            bookList = bookService.getBookByTag(searchName);
            for(Book book : bookList) {
                BookDto bookDto = new BookDto(book);
                bookDtoList.add(bookDto);
            }
        }
        return  bookDtoList;
    }
}
