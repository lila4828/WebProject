package com.example.webproject.service;

import com.example.webproject.entity.Book;

public interface bookService {
    public Book getBook(Long isbn); // 책 가져오기

    public Book saveBook(Book book);    // 책 저장하기

    public Book changBook(Long isbn, Book newbook); // 책 이름, 저자, 출시년도, 대출 가능 여부, 신규도서 여부 수정

    public void deleteBook(Long isbn);  // 책 지우기
}
