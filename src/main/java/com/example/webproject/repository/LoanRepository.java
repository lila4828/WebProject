package com.example.webproject.repository;

import com.example.webproject.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findAllByMemberID(String memberId);      // 멤버 아이디로 대출 정보 가져오기
}