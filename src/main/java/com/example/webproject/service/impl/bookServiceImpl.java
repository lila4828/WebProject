package com.example.webproject.service.impl;

import com.example.webproject.entity.Book;
import com.example.webproject.repository.BookRepository;
import com.example.webproject.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class bookServiceImpl implements bookService {

    private final BookRepository bookRepository;
    @Autowired
    public bookServiceImpl(BookRepository bookrepository) {
        this.bookRepository = bookrepository;
    }

    @Override
    public Book getBook(Long isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        if(book.isPresent()) {
            return book.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Book saveBook(Book book) {
        Book saveBook = bookRepository.save(book);
        System.out.println(saveBook);
        return saveBook;
    }

    @Override
    public Book changBook(Long isbn, Book newbook) {
        Optional<Book> oldBook = bookRepository.findById(isbn);
        Book newBook;
        if(oldBook.isPresent()) {
            newBook = oldBook.get();
            newBook.setBookName(newbook.getBookName());
            newBook.setAuthor(newbook.getAuthor());
            newBook.setYear(newbook.getYear());
            newBook.setLoanAvailability(newbook.getLoanAvailability());
            newBook.setNewBookAvailability(newbook.getNewBookAvailability());
        } else {
            throw new EntityNotFoundException();
        }
        return newBook;
    }

    @Override
    public void deleteBook(Long isbn) {
        Optional<Book> selectBook = bookRepository.findById(isbn);
        if(selectBook.isPresent()) {
            Book book = selectBook.get();
            bookRepository.delete(book);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
