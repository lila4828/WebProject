package com.example.webproject.service.impl;

import com.example.webproject.dto.CommentDto;
import com.example.webproject.entity.Board;
import com.example.webproject.entity.Comment;
import com.example.webproject.entity.Member;
import com.example.webproject.repository.CommentRepository;
import com.example.webproject.service.BoardService;
import com.example.webproject.service.CommentService;
import com.example.webproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BoardService boardService;
    private final MemberService memberService;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, BoardService boardService, MemberService memberService) {
        this.commentRepository = commentRepository;
        this.boardService = boardService;
        this.memberService = memberService;
    }

    @Override
    public List<Comment> getCommentList() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getCommentListByMemberId(String memberId) {
        return commentRepository.findAllByMemberId(memberId);
    }

    @Override
    public void addComment(CommentDto commentDto) {
        Board board = boardService.getBoard(commentDto.getBoardId());

        Comment comment = new Comment();
        Member joinMember = memberService.getMember(commentDto.getMemberId());
        comment.setMemberId(joinMember);
        comment.setComment(comment.getComment());
        commentRepository.save(comment);

        board.setCommentId(comment);
        boardService.saveBoard(board);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
