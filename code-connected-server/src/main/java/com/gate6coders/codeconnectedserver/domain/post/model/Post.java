package com.gate6coders.codeconnectedserver.domain.post.model;

import com.gate6coders.codeconnectedserver.domain.comment.model.Comment;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import lombok.*;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NonNull
//    @OneToOne
//    private Profile creator;

    @NonNull
    private String postContent;

    @NonNull
    private Long likes;

    @NonNull
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;
}

