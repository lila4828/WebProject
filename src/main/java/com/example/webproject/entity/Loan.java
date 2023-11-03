package com.example.webproject.entity;

import lombok.*;
import javax.persistence.*;
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
    private Integer loanNumber;

    @Column(nullable = false)
    private Date dateLoan;

    @Column
    private Date returnDate;

    @Column
    private Integer numberExtensions;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="memberId", referencedColumnName = "memberId")
    Member Member;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="isbn", referencedColumnName = "isbn")
    Book Book;
}

