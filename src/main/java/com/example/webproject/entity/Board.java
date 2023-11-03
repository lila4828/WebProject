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
@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardNumber;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="memberId", referencedColumnName = "memberId", nullable = false)
    Member Member;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="CommentId", referencedColumnName = "CommentId")
    Comment Comment;

}
