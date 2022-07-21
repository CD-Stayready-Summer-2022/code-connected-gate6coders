package com.gate6coders.codeconnectedserver.domain.post.model;

import com.gate6coders.codeconnectedserver.domain.comment.model.Comment;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private Profile creator;
    @NonNull
    private String postContent;
    @NonNull
    private Set<Profile> likes;
    @NonNull
    private List<Comment> comments;


    public Post(Long id, @NonNull Profile creator, @NonNull String postContent, @NonNull Set<Profile> likes, @NonNull List<Comment> comments) {
        this.id = id;
        this.creator = creator;
        this.postContent = postContent;
        this.likes = likes;
        this.comments = comments;
    }
}



