package com.example.webproject.service;

import com.example.webproject.entity.Comment;

public interface CommentService {
    public Comment getComment(Long id); // 댓글 불러오기

    public Comment saveComment(Comment comment);    // 댓글 작성하기

    public void deleteComment(Long id); // 댓글 지우기
}
