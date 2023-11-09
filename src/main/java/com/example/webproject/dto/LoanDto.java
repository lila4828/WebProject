package com.example.webproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LoanDto {
    private Long loanId;
    private Date dateLoan;
    private Date returnDate;
    private String memberId;    // 멤버아이디가 필수로 있어야된다.
    private Long isbn;          // 북 isbn이 필수로 있어야된다.
}
