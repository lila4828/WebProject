package com.example.webproject.service;

import com.example.webproject.dto.CommentDto;
import com.example.webproject.entity.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> getCommentList();                          // 댓글 불러오기

    public List<Comment> getCommentListByMemberId(String memberId); // 멤버 아이디로 댓글 불러오기
    // 필요하나?

    public void addComment(CommentDto commentDto);                  // 게시판에 댓글 달기

    public void deleteComment(Long id);                             // 댓글 지우기
}
