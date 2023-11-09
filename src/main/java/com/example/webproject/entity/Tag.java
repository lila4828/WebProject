package com.example.webproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString()
@Table(name = "Tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TagId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="isbn", referencedColumnName = "isbn")
    private Book isbn;

    @Column
    private String tag;
}
