package com.example.webproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookDto {
    private Long isbn;
    private String bookName;
    private String author;
    private Date year;
    private Boolean loanAvailability;
    private Boolean newBookAvailability;
    private String tag;
}
