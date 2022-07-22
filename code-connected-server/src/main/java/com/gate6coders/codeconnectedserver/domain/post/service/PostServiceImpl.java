package com.gate6coders.codeconnectedserver.domain.post.service;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ProfileNotFoundException;
import com.gate6coders.codeconnectedserver.domain.post.model.Post;
import com.gate6coders.codeconnectedserver.domain.post.repo.PostRepo;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
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
    public Post getById(Long id) throws ProfileNotFoundException {
        return postRepo.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("This profile cannot be found"));
    }

    @Override
    public List<Post> getProfiles() {
        return postRepo.findAll();
    }

    @Override
    public List<Post> getFollowers() {
        return null;
    }

    @Override
    public Long getById(Post post) {
        return null;
    }

    @Override
    public Integer getNumberOfLikes() {
        return null;
    }

    @Override
    public Post findByFullName() {
        return null;
    }
}
