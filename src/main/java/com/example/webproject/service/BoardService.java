package com.example.webproject.service;

import com.example.webproject.entity.Board;

public interface BoardService {
    public Board getBoard(Long id); // 게시판 가져오기

    public Board saveBoard(Board board);    // 게시판 만들기

    public Board changBoard(Long id, Board newBoard);   // 게시판 내용변경

    public void deleteBoard(Long id);   // 게시판 지우기
}
