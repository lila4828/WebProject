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
@Table(name = "Announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeNumber;

    @Column
    private String noticePriority;

    @Column(nullable = false)
    private String noticeTitle;

    @Column(nullable = false)
    private String noticeContent;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="memberId", referencedColumnName = "memberId")
    private Member memberId;
}
