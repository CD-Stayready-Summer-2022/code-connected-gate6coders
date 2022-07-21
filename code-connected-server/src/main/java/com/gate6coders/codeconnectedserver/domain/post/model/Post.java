package com.gate6coders.codeconnectedserver.domain.post.model;

import com.gate6coders.codeconnectedserver.domain.comment.model.Comment;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
<<<<<<< HEAD
import org.springframework.lang.NonNull;

=======
import lombok.*;

import javax.persistence.Entity;
>>>>>>> b8cc4cd1ab9196d82d0e102f86b93c30889d3a35
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;

<<<<<<< HEAD
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


=======
@Data
@Entity
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
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

}

>>>>>>> b8cc4cd1ab9196d82d0e102f86b93c30889d3a35
