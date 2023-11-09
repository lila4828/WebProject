package com.example.webproject.service;

import com.example.webproject.dto.BookDto;
import com.example.webproject.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> getBookList();            // 모든 책 리스트 가져오기

    public Long getCountBook();                 // 총 권수 가져오기

    public Book getBook(Long isbn);             // isbn으로 책 가져오기

    public Book getBookName(String bookName);   // 이름으로 책 가져오기

    public void saveBook(BookDto bookDto);      // 책 저장하기
    
    public void addTag(Long isbn, BookDto bookDto);     // 책에 태그 추가

    public void changeBook(Long isbn, BookDto bookDto); // 책 이름, 저자, 출시년도, 대출 가능 여부, 신규도서 여부 수정

    public void deleteBook(Long isbn);                  // 책 지우기

    public void changeLoanAvailability(Long isbn);      // 대출 현황 변경

    //미구현
    //public List<Book> getBookList(String tag);          // Tag로 책 리스트 가져오기
}
