package com.example.webproject.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
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
    private Long isbn;  // isbn

    @Column(nullable = false)
    public String bookName; // 책 이름

    @Column(nullable = false)
    private String author;  // 저자

    @Column(nullable = false)
    private Date year;      // 출시년도

    @Column(nullable = false)
    private Boolean loanAvailability;   // 대출가능

    @Column(nullable = false)
    private Boolean newBookAvailability;    // 새로운 책 여부

    @Column
    @ColumnDefault("0")
    private Long numberLoan;        // 대출횟수, 추천하는 책

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="TagId", referencedColumnName = "TagId")
    private Tag tag;

    @Column
    private String imageUrl;
}
