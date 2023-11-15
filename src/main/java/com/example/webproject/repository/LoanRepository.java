package com.example.webproject.repository;

import com.example.webproject.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findAllByMemberID(String memberId);      // 멤버아디로 대출한것 가져오기
}