package com.gate6coders.codeconnectedserver.domain.comment.service;

import com.gate6coders.codeconnectedserver.domain.comment.model.Comment;
import com.gate6coders.codeconnectedserver.domain.comment.repo.CommentRepo;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepo commentRepo;

    @Autowired
    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment create(Comment comment)  {
        return commentRepo.save(comment);
    }

    @Override
    public Comment update(Long id, Comment comment) throws ResourceNotFoundException {
        Comment commentUpdate = getById(id);
        commentUpdate.setContent(comment.getContent());
        commentUpdate.setCommenter(comment.getCommenter());
        commentUpdate.setDatePosted(comment.getDatePosted());
        return commentRepo.save(comment);
    }

    @Override
    public Comment getById(Long id) throws ResourceNotFoundException {
        return commentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with this ID does not exist"));
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Comment comment = getById(id);
        commentRepo.delete(comment);
    }
}
