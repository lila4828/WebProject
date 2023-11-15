package com.example.webproject.repository;

import com.example.webproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByBookName(String bookName);         // 이름으로 책리스트 가져오기
}
