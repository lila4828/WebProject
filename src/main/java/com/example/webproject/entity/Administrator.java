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
@Table(name = "Administrator")
public class Administrator {

    @Id
    private String adminId;

    @Column(nullable = false)
    private String adminPassword;

}
