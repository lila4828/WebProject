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

import java.util.List;

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
    public Long getCountLoan() {
        return loanRepository.count();
    }

    @Override
    public List<Loan> getLoanList(String memberId) {
        return loanRepository.findAllByMemberID(memberId);
    }

    @Override
    public void bookLoan(LoanDto loanDto) {
        Loan saveLoan = new Loan();
        saveLoan.setDateLoan(loanDto.getDateLoan());

        Member joinMember = memberRepository.findById(loanDto.getMemberId()).orElse(null);
        saveLoan.setMemberID(joinMember);

        Book joinBook = bookRepository.findById(loanDto.getIsbn()).orElse(null);
        saveLoan.setIsbn(joinBook);

        loanRepository.save(saveLoan);
        bookService.changeLoanAvailability(joinBook.getIsbn());
    }

    @Override
    public void extendLoan(Long id) {
        Loan selectLoan = loanRepository.findById(id).orElse(null);

        Long loanNumberExtensions = selectLoan.getNumberExtensions();

        selectLoan.setNumberExtensions(loanNumberExtensions+1);

        loanRepository.save(selectLoan);
    }

    @Override
    public void returnLoan(Long id, LoanDto loanDto) {
        Loan selectLoan = loanRepository.findById(id).orElse(null);

        selectLoan.setReturnDate(loanDto.getReturnDate());

        loanRepository.save(selectLoan);

        Book joinBook = bookRepository.findById(loanDto.getIsbn()).orElse(null);
        bookService.changeLoanAvailability(joinBook.getIsbn());
    }
}