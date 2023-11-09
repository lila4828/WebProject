package com.example.webproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
    private Long boardNumber;
    private String title;
    private String content;
    private String memberId;
    private Long commentId;
}
