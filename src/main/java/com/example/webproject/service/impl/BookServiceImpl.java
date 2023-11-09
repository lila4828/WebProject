package com.example.webproject.service.impl;

import com.example.webproject.dto.BookDto;
import com.example.webproject.entity.Book;
import com.example.webproject.entity.Tag;
import com.example.webproject.repository.BookRepository;
import com.example.webproject.repository.TagRepository;
import com.example.webproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final TagRepository tagRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookrepository, TagRepository tagRepository) {
        this.bookRepository = bookrepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAllAddTag();
    }

    @Override
    public Long getCountBook() {
        return bookRepository.count();
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
    public Book getBookName(String bookName) {
        Optional<Book> book = bookRepository.findByBookName(bookName);
        if(book.isPresent()) {
            return book.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void saveBook(BookDto bookDto) {
        Book saveBook = new Book();
        saveBook.setIsbn(bookDto.getIsbn());
        saveBook.setBookName(bookDto.getBookName());
        saveBook.setAuthor(bookDto.getAuthor());
        saveBook.setYear(bookDto.getYear());
        saveBook.setLoanAvailability(bookDto.getLoanAvailability());
        saveBook.setNewBookAvailability(bookDto.getNewBookAvailability());

        bookRepository.save(saveBook);
    }

    @Override
    public void addTag(Long isbn, BookDto bookDto) {
        Optional<Book> oldBook = bookRepository.findById(isbn);
        if(oldBook.isPresent()) {
            Book newBook = oldBook.get();

            Tag jointag = new Tag();
            jointag.setTag(bookDto.getTag());
            tagRepository.save(jointag);

            newBook.setTag(jointag);
            bookRepository.save(newBook);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void changeBook(Long isbn, BookDto bookDto) {
        Optional<Book> oldBook = bookRepository.findById(isbn);
        if(oldBook.isPresent()) {
            Book newBook = oldBook.get();

            newBook.setBookName(bookDto.getBookName());
            newBook.setAuthor(bookDto.getAuthor());
            newBook.setYear(bookDto.getYear());
            newBook.setLoanAvailability(bookDto.getLoanAvailability());
            newBook.setNewBookAvailability(bookDto.getNewBookAvailability());

            bookRepository.save(newBook);
        } else {
            throw new EntityNotFoundException();
        }
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

    @Override
    public void changeLoanAvailability(Long isbn) {
        Optional<Book> oldBook = bookRepository.findById(isbn);
        if(oldBook.isPresent()) {
            Book newBook = oldBook.get();
            if(newBook.getLoanAvailability()) {
                newBook.setLoanAvailability(false);
            }
            else {
                newBook.setLoanAvailability(true);
            }
            bookRepository.save(newBook);
        } else {
            throw new EntityNotFoundException();
        }
    }
    
    // 구현중
    /*@Override
    public List<Book> getBookList(String tag) {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }*/
}
