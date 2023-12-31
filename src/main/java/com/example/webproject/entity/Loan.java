package com.example.webproject.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString()
@Table(name = "Loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column
    private LocalDate dateLoan;

    @Column
    private LocalDate returnDate;

    @Column
    private Long numberExtensions;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="memberId", referencedColumnName = "memberId")
    private Member memberID;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="isbn", referencedColumnName = "isbn")
    private Book isbn;

}

