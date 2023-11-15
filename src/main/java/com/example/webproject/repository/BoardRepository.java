package com.example.webproject.repository;

import com.example.webproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByMemberId(String memberId);     // 멤버 아이디로 게시판리스트 가져오기
}
