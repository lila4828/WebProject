package com.example.webproject.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString()
@Table(name = "Book")
public class Book {

    @Id
    private Long isbn;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Date year;

    @Column(nullable = false)
    private String loanAvailability;

    @Column(nullable = false)
    private String newBookAvailability;

    @Column
    private Integer numberLoan;


}
