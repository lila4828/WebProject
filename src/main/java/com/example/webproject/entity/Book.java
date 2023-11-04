package com.example.webproject.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
    public String bookName;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Date year;

    @Column(nullable = false)
    private Boolean loanAvailability;

    @Column(nullable = false)
    private Boolean newBookAvailability;

    @Column
    @ColumnDefault("0")
    private Long numberLoan;

}
