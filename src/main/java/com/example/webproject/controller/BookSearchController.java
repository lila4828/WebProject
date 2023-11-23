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
    public String GoSearch() {

        return "view/Search/SearchPage";
    }

    @PostMapping("/SearchBook")
    public String bookSearch(@RequestParam("selectSearch") String selectSearch,
                             @RequestParam("searchName") String searchName, Model model)
    {
        System.out.print(selectSearch);
        System.out.print(searchName);

        List<Book> bookList = new ArrayList<>();
        if(selectSearch.equals("제목")) {
            bookList = bookService.getBookName(searchName);
        }
        else if (selectSearch.equals("태그")) {
            bookList = bookService.getBookByTag(searchName);
        }

        int bookCount = 0;
        List<BookDto> bookDtoList = new ArrayList<>();
        for(Book book : bookList) {
            BookDto bookDto = new BookDto();
            bookCount++;

            bookDto.setImageUrl(book.getImageUrl());
            bookDto.setIsbn(book.getIsbn());
            bookDto.setBookName(book.getBookName());
            bookDto.setAuthor(book.getAuthor());
            bookDto.setYear(book.getYear());
            bookDto.setLoanAvailability(book.getLoanAvailability());
            bookDto.setNewBookAvailability(book.getNewBookAvailability());
            bookDto.setTag(book.getTag().getTag());
            
            bookDtoList.add(bookDto);
        }
        model.addAttribute("bookList", bookDtoList);
        model.addAttribute("bookCount", bookCount);

        return "view/Search/SearchPage";
    }
}
