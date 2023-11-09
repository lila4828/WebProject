package com.example.webproject.service.impl;

import com.example.webproject.dto.BoardDto;
import com.example.webproject.dto.CommentDto;
import com.example.webproject.entity.Board;
import com.example.webproject.entity.Comment;
import com.example.webproject.entity.Member;
import com.example.webproject.repository.BoardRepository;
import com.example.webproject.repository.MemberRepository;
import com.example.webproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository, MemberRepository memberRepository) {
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    @Override
    public void saveBoard(BoardDto boardDto) {
        Board saveBoard = new Board();
        saveBoard.setTitle(boardDto.getTitle());
        saveBoard.setContent(boardDto.getContent());

        Optional<Member> joinMember = memberRepository.findById(boardDto.getMemberId());
        saveBoard.setMemberId(joinMember.get());
        boardRepository.save(saveBoard);
    }

    @Override
    public void changeBoard(Long id, BoardDto newBoardDto) {
        Optional<Board> oldBoard = boardRepository.findById(id);
        if(oldBoard.isPresent()) {
            Board newBoard = oldBoard.get();

            newBoard.setTitle(newBoardDto.getTitle());
            newBoard.setContent(newBoardDto.getContent());

            boardRepository.save(newBoard);
        } else {
            throw new EntityNotFoundException();
        }
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
