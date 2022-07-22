package com.gate6coders.codeconnectedserver.domain.profile.model;

import com.gate6coders.codeconnectedserver.aboutUser.model.AboutUser;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String userName;

    @NonNull
    private String password;

    @OneToOne(targetEntity = AboutUser.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "about_id", referencedColumnName = "id")
    @NonNull
    private AboutUser aboutUser;

//    @OneToMany(cascade = CascadeType.ALL)
//    @NonNull
//    private List<Profile> follower;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @NonNull
//    private List<Profile> following;
}

