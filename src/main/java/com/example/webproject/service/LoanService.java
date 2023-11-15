package com.example.webproject.service;

import com.example.webproject.dto.LoanDto;
import com.example.webproject.entity.Loan;

import java.util.Date;
import java.util.List;

public interface LoanService {

    public List<Loan> getLoanList();                       // 대출 현황 불러오기
    
    public List<Loan> getLoanList(String memberId);        // 멤버 아이디로만 대출 현황 불러온다.

    public void bookLoan(LoanDto loanDto);                 // 대출 하기

    public void extendLoan(Long id);                       // 대출 횟수 늘리기

    public void returnLoan(Long id, LoanDto loanDto);       // 대출 반납하기

}
