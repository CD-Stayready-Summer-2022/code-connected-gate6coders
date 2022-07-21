package com.gate6coders.codeconnectedserver.domain.profile.model;

import com.gate6coders.codeconnectedserver.domain.aboutUser.model.AboutUser;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @NonNull
    private AboutUser aboutUser;

    @NonNull
    private List<Profile> follower;

    @NonNull
    private List<Profile> following;
}
