package com.example.webproject.service.impl;

import com.example.webproject.entity.Comment;
import com.example.webproject.repository.CommentRepository;
import com.example.webproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment getComment(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()) {
            return comment.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Comment saveComment(Comment comment) {
        Comment saveComment = commentRepository.save(comment);
        System.out.println(saveComment);
        return saveComment;
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
