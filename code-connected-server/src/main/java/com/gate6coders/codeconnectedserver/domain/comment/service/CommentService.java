package com.gate6coders.codeconnectedserver.domain.comment.service;

import com.gate6coders.codeconnectedserver.domain.comment.model.Comment;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;

import java.util.List;

public interface CommentService {
    Comment create (Comment comment);
    Comment update (Long id, Comment comment) throws  ResourceNotFoundException;
    Comment getById(Long id) throws ResourceNotFoundException;
    List<Comment> getAllComments();
    void delete(Long id) throws ResourceNotFoundException;
}
