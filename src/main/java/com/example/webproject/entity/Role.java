package com.example.webproject.entity;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("ADMIN"),
    MEMBER("MEMBER");
    Role(String value) {
        this.value = value;
    }

    private String value;
}
