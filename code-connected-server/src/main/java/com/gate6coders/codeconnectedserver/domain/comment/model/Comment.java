package com.gate6coders.codeconnectedserver.domain.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gate6coders.codeconnectedserver.domain.post.model.Post;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Profile.class)
    @JoinColumn(name = "commenter_id", referencedColumnName = "id")
    private Profile commenter;

    @NonNull
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePosted;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "post_id")
    private Post post;

    @PrePersist
    public void onPost(){
        datePosted = new Date();
    }
}
