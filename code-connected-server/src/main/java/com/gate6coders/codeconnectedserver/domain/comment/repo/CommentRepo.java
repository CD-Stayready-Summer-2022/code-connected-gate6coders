package com.gate6coders.codeconnectedserver.domain.comment.repo;

import com.gate6coders.codeconnectedserver.domain.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {

}
