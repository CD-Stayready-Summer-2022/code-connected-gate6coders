package com.gate6coders.codeconnectedserver.domain.comment.model;

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

    @ManyToOne
    @NonNull
    private Profile profile;

    @NonNull
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePosted;

    @PrePersist
    public void onPost(){
        datePosted = new Date();
    }
}
