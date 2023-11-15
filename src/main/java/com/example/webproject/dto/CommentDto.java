package com.example.webproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private Long boardId;       // 게시판 번호
    private String memberId;    // 작성한 멤버 아이디
    private String comment;     // 내용
}
