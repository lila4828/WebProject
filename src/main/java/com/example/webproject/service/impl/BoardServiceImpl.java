package com.example.webproject.service.impl;

import com.example.webproject.entity.Board;
import com.example.webproject.repository.BoardRepository;
import com.example.webproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board getBoard(Long id) {
        Optional<Board> board = boardRepository.findById(id);
        if(board.isPresent()) {
            return board.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Board saveBoard(Board board) {
        Board saveBoard = boardRepository.save(board);
        System.out.println(saveBoard);
        return saveBoard;
    }

    @Override
    public Board changBoard(Long id, Board newboard) {
        Optional<Board> oldBoard = boardRepository.findById(id);
        Board newBoard;
        if(oldBoard.isPresent()) {
            newBoard = oldBoard.get();
            newBoard.setContent(newboard.getContent());
        } else {
            throw new EntityNotFoundException();
        }
        return newBoard;
    }

    @Override
    public void deleteBoard(Long id) {
        Optional<Board> selectBoard = boardRepository.findById(id);
        if(selectBoard.isPresent()) {
            Board board = selectBoard.get();
            boardRepository.delete(board);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
