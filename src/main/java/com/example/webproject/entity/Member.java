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

    @Enumerated(EnumType.STRING)
    private Role role;
}
