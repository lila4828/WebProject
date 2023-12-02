package com.example.webproject.repository;

import com.example.webproject.entity.Book;
import com.example.webproject.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByBookName(String bookName);

    List<Book> findAllByTag(Tag tag);
}
