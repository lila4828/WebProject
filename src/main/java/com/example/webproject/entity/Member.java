package com.example.webproject.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString()
@Table(name = "Member")
public class Member {

    @Id
    private String memberId;

    @Column(nullable = false)
    private String memberPassword;

    @Column()
    private String address;

    @Column()
    private String phone;

    @Column()
    private String email;
}
