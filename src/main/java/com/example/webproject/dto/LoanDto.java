package com.example.webproject.dto;

import com.example.webproject.entity.Loan;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LoanDto {
    private Long loanId;
    private LocalDate dateLoan;      // 대출 날짜
    private LocalDate returnDate;    // 반납 날짜
    private Long numberExtensions;
    private String memberId;    // 멤버아이디가 필수로 있어야된다.
    private Long isbn;          // 북 isbn이 필수로 있어야된다.

    public LoanDto() {}
    public LoanDto(Loan loan) {
        this.loanId = loan.getLoanId();
        this.dateLoan = loan.getDateLoan();
        this.returnDate = loan.getReturnDate();
        this.numberExtensions = loan.getNumberExtensions();
        this.isbn = loan.getIsbn().getIsbn();
        this.memberId = loan.getMemberID().getMemberId();
    }
}
