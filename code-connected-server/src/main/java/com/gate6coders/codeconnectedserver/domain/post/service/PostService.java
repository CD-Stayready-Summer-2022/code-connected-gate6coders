package com.gate6coders.codeconnectedserver.domain.post.service;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ProfileNotFoundException;
import com.gate6coders.codeconnectedserver.domain.post.model.Post;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;

import java.util.List;

public interface PostService {
    Post getById(Long id) throws ProfileNotFoundException;
    List<Post> getProfiles();
    List<Post> getFollowers();
    Long getById(Post post);
    Integer getNumberOfLikes();
    Post findByFullName();
}
