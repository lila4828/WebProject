package com.example.webproject.entity;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    MEMBER("ROLE_MEMBER");
    Role(String value) {
        this.value = value;
    }

    private String value;
}