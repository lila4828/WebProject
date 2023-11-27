package com.example.webproject.service;

import com.example.webproject.entity.Loan;

import java.time.LocalDate;
import java.util.List;

public interface LoanService {

    public Loan getLoanId(Long Id);                         // Id로 대출 가져오기

    public List<Loan> getLoanList();                       // 대출 현황 불러오기

    public Long getCountLoan();                            // 총 대출 건수 가져오기

    public List<Loan> getLoanList(String memberId);        // 멤버 아이디로만 대출 현황 불러온다.

    public void bookLoan(Loan loan);                 // 대출 하기

    public void extendLoan(Long id);                       // 대출 횟수 늘리기

    public void returnLoan(Long id, LocalDate loanDto);       // 대출 반납하기

}