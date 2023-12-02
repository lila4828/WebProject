package com.example.webproject.dto;

import com.example.webproject.entity.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookDto {
    private Long isbn;                      // 책 isbn
    private String bookName;                // 책 이름
    private String author;                  // 저자
    private String year;                      // 출시년도
    private Boolean loanAvailability;       // 대출가능여부
    private Boolean newBookAvailability;    // 새로운 책 여부
    private String tag;                     // 태그이름
    private String imageUrl;                // 이미지

    public BookDto() {}
    public BookDto(Book book) {
        this.isbn = book.getIsbn();
        this.bookName = book.getBookName();
        this.author = book.getAuthor();
        this.year = book.getYear();
        this.loanAvailability = book.getLoanAvailability();
        this.newBookAvailability = book.getNewBookAvailability();
        this.tag = book.getTag().getTag();
        this.imageUrl = book.getImageUrl();
    }
}
