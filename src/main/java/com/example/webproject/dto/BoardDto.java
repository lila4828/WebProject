package com.example.webproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
    private String title;               // 게시판 제목
    private String content;             // 게시판 내용
    private String memberId;            // 작성한 멤버 아이디
}
