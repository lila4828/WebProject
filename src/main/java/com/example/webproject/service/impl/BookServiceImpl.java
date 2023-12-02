package com.example.webproject.service.impl;

import com.example.webproject.dto.BookDto;
import com.example.webproject.dto.TagDto;
import com.example.webproject.entity.Book;
import com.example.webproject.entity.Tag;
import com.example.webproject.repository.BookRepository;
import com.example.webproject.service.BookService;
import com.example.webproject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final TagService tagService;
    @Autowired
    public BookServiceImpl(BookRepository bookrepository, TagService tagService) {
        this.bookRepository = bookrepository;
        this.tagService = tagService;
    }

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Long getCountBook() { return bookRepository.count(); }

    @Override
    public Book getBook(Long isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }

    @Override
    public List<Book> getBookName(String bookName) {
        return bookRepository.findAllByBookName(bookName);
    }

    @Override
    public List<Book> getBookByTag(String tag) {
        Tag selectTag = tagService.getTagByName(tag);
        List<Book> bookList = bookRepository.findAllByTag(selectTag);

        return bookList;
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void addTag(Long isbn, TagDto tagDto) {
        Book selectBook = bookRepository.findById(isbn).orElse(null);

        Tag tag;
        Tag existTag = tagService.getTagByName(tagDto.getTag());
        if(existTag != null) {
            tag = existTag;
        }else {
            tag = new Tag();
            tag.setTag(tag.getTag());
            tagService.saveTag(tag);
        }

        selectBook.setTag(tag);
        bookRepository.save(selectBook);
    }

    @Override
    public void changeBook(Long isbn, BookDto bookDto) {
        Book selectBook = bookRepository.findById(isbn).orElse(null);

        selectBook.setBookName(bookDto.getBookName());
        selectBook.setAuthor(bookDto.getAuthor());
        selectBook.setYear(bookDto.getYear());
        selectBook.setLoanAvailability(bookDto.getLoanAvailability());
        selectBook.setNewBookAvailability(bookDto.getNewBookAvailability());
        selectBook.setTag(tagService.getTagByName(bookDto.getTag()));

        bookRepository.save(selectBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void changeLoanAvailability(Long isbn) {
        Book selectBook = bookRepository.findById(isbn).orElse(null);
        if(selectBook != null) {
            if(selectBook.getLoanAvailability()) {
                selectBook.setLoanAvailability(false);
            }
            else {
                selectBook.setLoanAvailability(true);
            }
            bookRepository.save(selectBook);
        } else {
            throw new EntityNotFoundException();
        }
    }

}
