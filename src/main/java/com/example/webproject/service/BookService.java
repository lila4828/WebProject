package com.example.webproject.service;

import com.example.webproject.entity.Book;
import com.example.webproject.entity.Tag;

import java.util.List;

public interface BookService {

    public List<Book> getBookList();  // 모든 책 리스트 가져오기

    public Book getBook(Long isbn); // isbn으로 책 가져오기

    public Book getBookName(String bookName); // 이름으로 책 가져오기

    public Book saveBook(Book book);    // 책 저장하기
    
    public Book addTag(Long isbn, Tag tagId);  // 책에 태그 추가

    public Book changBook(Long isbn, Book newbook); // 책 이름, 저자, 출시년도, 대출 가능 여부, 신규도서 여부 수정

    public void deleteBook(Long isbn);  // 책 지우기

    public Long getCountBook(); // 총 권수 가져오기
}
