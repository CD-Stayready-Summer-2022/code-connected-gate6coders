package com.gate6coders.codeconnectedserver.domain.post.service;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ProfileNotFoundException;
import com.gate6coders.codeconnectedserver.domain.post.model.Post;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;

import java.util.List;

public interface PostService {
    Profile getById(Long id) throws ProfileNotFoundException;
    List<Profile> getProfiles();
    List<Profile> getFollowers();
    Long getById(Post post);
    Integer getNumberOfLikes();
    Post findByFullName();
}
