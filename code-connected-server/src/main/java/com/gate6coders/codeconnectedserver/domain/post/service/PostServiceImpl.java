package com.gate6coders.codeconnectedserver.domain.post.service;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ProfileNotFoundException;
import com.gate6coders.codeconnectedserver.domain.post.model.Post;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;

import java.util.List;

public class PostServiceImpl implements PostService {

    @Override
    public Profile getById(Long id) throws ProfileNotFoundException {
        return null;
    }

    @Override
    public List<Profile> getProfiles() {
        return null;
    }

    @Override
    public List<Profile> getFollowers() {
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
