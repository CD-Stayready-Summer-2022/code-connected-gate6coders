package com.gate6coders.codeconnectedserver.domain.post.service;
import com.gate6coders.codeconnectedserver.domain.comment.model.Comment;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.gate6coders.codeconnectedserver.domain.post.model.Post;
import java.util.List;

public interface PostService {


    Post getById(Long id) throws ResourceNotFoundException;
    List<Post> getAllPosts();
    Post create(Post post);
    List<Post> getFollowers();
    Long getById(Post post);
    List<Comment> getAllLikes(Long postId);
    String getPostContent(Post postContent) throws ResourceNotFoundException;
    Integer getNumberOfLikes();
    Post updateContent(Long id, Post postContent) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
