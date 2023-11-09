package com.example.webproject.repository;

import com.example.webproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookName(String bookName);
    @Query(value="select * from Book INNER JOIN Tag ON Book.isbn = Tag.isbn", nativeQuery=true)
    List<Book> findAllAddTag();
}
