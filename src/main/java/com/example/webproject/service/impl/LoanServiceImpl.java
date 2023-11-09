package com.example.webproject.service.impl;

import com.example.webproject.dto.LoanDto;
import com.example.webproject.entity.Book;
import com.example.webproject.entity.Loan;
import com.example.webproject.entity.Member;
import com.example.webproject.repository.BookRepository;
import com.example.webproject.repository.LoanRepository;
import com.example.webproject.repository.MemberRepository;
import com.example.webproject.service.BookService;
import com.example.webproject.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    private final BookService bookService;
    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, MemberRepository memberRepository, BookRepository bookRepository, BookService bookService) {
        this.loanRepository = loanRepository;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @Override
    public List<Loan> getLoanList() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> getLoanList(String memberId) {
        return loanRepository.findAllByMemberID(memberId);
    }

    @Override
    public Loan bookLoan(LoanDto loanDto) {
        Loan saveLoan = new Loan();
        saveLoan.setDateLoan(loanDto.getDateLoan());

        Optional<Member> joinMember = memberRepository.findById(loanDto.getMemberId());
        saveLoan.setMemberID(joinMember.get());
        Optional<Book> joinBook = bookRepository.findById(loanDto.getIsbn());
        saveLoan.setIsbn(joinBook.get());

        saveLoan.setNumberExtensions(0L);

        loanRepository.save(saveLoan);
        bookService.changeLoanAvailability(loanDto.getIsbn());
        return saveLoan;
    }

    @Override
    public void extendLoan(Long id) {
        Optional<Loan> oldLoan = loanRepository.findById(id);
        if(oldLoan.isPresent()) {
            Loan newLoan = oldLoan.get();
            Long numberExtensions = oldLoan.get().getNumberExtensions();

            newLoan.setNumberExtensions(numberExtensions+1);

            loanRepository.save(newLoan);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void returnLoan(Long id, LoanDto loanDto) {
        Optional<Loan> oldLoan = loanRepository.findById(id);
        if(oldLoan.isPresent()) {
            Loan newLoan = oldLoan.get();

            newLoan.setReturnDate(loanDto.getReturnDate());

            loanRepository.save(newLoan);
            bookService.changeLoanAvailability(loanDto.getIsbn());
        } else {
            throw new EntityNotFoundException();
        }
    }
}
