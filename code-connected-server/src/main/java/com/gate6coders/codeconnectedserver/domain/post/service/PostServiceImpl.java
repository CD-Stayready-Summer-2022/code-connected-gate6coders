package com.gate6coders.codeconnectedserver.domain.post.service;
import com.gate6coders.codeconnectedserver.domain.comment.model.Comment;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.gate6coders.codeconnectedserver.domain.post.model.Post;
import com.gate6coders.codeconnectedserver.domain.post.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepo postRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public Post getById(Long id) throws ResourceNotFoundException {
        return postRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This profile cannot be found"));
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post create(Post post) {
        return postRepo.save(post);
    }

    @Override
    public Long getById(Post post) {
        return null;
    }

    @Override
    public Post updateContent(Long id, Post postContent) throws ResourceNotFoundException {
        Post post = getById(id);
        post.setPostContent(postContent.getPostContent());
        return postRepo.save(post);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Post post = getById(id);
        postRepo.delete(post);
    }
}