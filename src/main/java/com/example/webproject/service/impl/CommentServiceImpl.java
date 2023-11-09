package com.example.webproject.service.impl;

import com.example.webproject.dto.CommentDto;
import com.example.webproject.entity.Board;
import com.example.webproject.entity.Comment;
import com.example.webproject.entity.Member;
import com.example.webproject.repository.BoardRepository;
import com.example.webproject.repository.CommentRepository;
import com.example.webproject.repository.MemberRepository;
import com.example.webproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, BoardRepository boardRepository, MemberRepository memberRepository) {
        this.commentRepository = commentRepository;
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Comment> getCommentList() {
        return commentRepository.findAll();
    }

    @Override
    public void addComment(Long boardId, CommentDto commentDto) {
        Optional<Board> board = boardRepository.findById(boardId);
        if(board.isPresent()) {
            Board newBoard = board.get();

            Comment comment = new Comment();
            Optional<Member> joinMember = memberRepository.findById(commentDto.getMemberId());
            comment.setMemberId(joinMember.get());
            comment.setComment(comment.getComment());

            newBoard.setCommentId(comment);
            boardRepository.save(newBoard);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void deleteComment(Long id) {
        Optional<Comment> selectComment = commentRepository.findById(id);
        if(selectComment.isPresent()) {
            Comment comment = selectComment.get();
            commentRepository.delete(comment);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
