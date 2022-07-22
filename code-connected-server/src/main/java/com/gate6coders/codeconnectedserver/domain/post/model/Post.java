package com.gate6coders.codeconnectedserver.domain.post.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NonNull
//    private Profile creator;

    @NonNull
    private String postContent;

//    @NonNull
//    private Set<Profile> likes;
//
//    @NonNull
//    private List<Comment> comments;

}

