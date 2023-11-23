package com.example.webproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookDto {
    private Long isbn;                      // 책 isbn
    private String bookName;                // 책 이름
    private String author;                  // 저자
    private Date year;                      // 출시년도
    private Boolean loanAvailability;       // 대출가능여부
    private Boolean newBookAvailability;    // 새로운 책 여부
    private String tag;                     // 태그이름
    private String imageUrl;                // 이미지
}
