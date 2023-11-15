package com.example.webproject.repository;

import com.example.webproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByMemberId(String memberId);       // 멤버 아이디로 작성한 댓글리스트 가져오기
}