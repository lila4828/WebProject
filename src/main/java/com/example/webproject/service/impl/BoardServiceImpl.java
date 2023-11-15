package com.example.webproject.service.impl;

import com.example.webproject.dto.BoardDto;
import com.example.webproject.entity.Board;
import com.example.webproject.repository.BoardRepository;
import com.example.webproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    @Override
    public Board getBoard(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public List<Board> getBoardList(String memberId){
        return boardRepository.findAllByMemberId(memberId);
    }

    @Override
    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void changeBoard(Long id, BoardDto newBoardDto) {
        Board selectBoard = boardRepository.findById(id).orElse(null);

        selectBoard.setTitle(newBoardDto.getTitle());
        selectBoard.setContent(newBoardDto.getContent());

        boardRepository.save(selectBoard);
    }

    @Override
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
