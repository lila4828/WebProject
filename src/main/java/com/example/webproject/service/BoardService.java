package com.example.webproject.service;

import com.example.webproject.dto.BoardDto;
import com.example.webproject.dto.CommentDto;
import com.example.webproject.entity.Board;

import java.util.List;

public interface BoardService {
    public List<Board> getBoardList();          // 게시판리스트 가져오기

    public Board getBoard(Long id);             // 게시판 id로 가져오기

    public List<Board> getBoardList(String memberId);   // 멤버아이디로 게시판 가져오기

    public void saveBoard(Board board);         // 게시판 만들기

    public void changeBoard(Long id, BoardDto newboardDto);   // 게시판 내용변경, 제목과 내용 변경

    public void deleteBoard(Long id);           // 게시판 지우기
}
