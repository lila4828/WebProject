package com.example.webproject.service;

import com.example.webproject.entity.Loan;

import java.util.Date;

public interface LoanService {

    public Loan getLoan(Long id);   // 대출 현황 불러오기

    public Loan saveLoan(Loan loan);    // 대출 하기

    public Loan extendLoan(Long id); // 대출 횟수 늘리기

    public Loan returnLoan(Long id, Date date); // 대출 반납하기

}
