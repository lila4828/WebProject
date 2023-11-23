package com.example.webproject.service;

import com.example.webproject.dto.BookDto;
import com.example.webproject.dto.TagDto;
import com.example.webproject.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> getBookList(); // 모든 책 리스트 가져오기
    
    public Long getCountBook(); // 총 권수 가져오기

    public Book getBook(Long isbn);             // isbn으로 책 가져오기

    public List<Book> getBookName(String bookName);   // 책 이름으로 리스트 가져오기
    
    public List<Book> getBookByTag(String tag);       // 태그 이름으로 리스트 가져오기

    public void saveBook(Book book);                    // 책 저장하기
    
    public void addTag(Long isbn, TagDto tagDto);       // 책에 태그 추가

    public void changeBook(Long isbn, BookDto bookDto); // 책 이름, 저자, 출시년도, 대출 가능 여부, 신규도서 여부 수정

    public void deleteBook(Long isbn);                  // 책 지우기

    public void changeLoanAvailability(Long isbn);      // 대출 현황 변경

}
