package com.gate6coders.codeconnectedserver.domain.profile.model;

import com.gate6coders.codeconnectedserver.domain.aboutUser.model.AboutUser;
import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "profile_group",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    @NonNull
    private Set<Group> groupMembers;

    public Profile(String firstName, String lastName, String email, String userName, String password, AboutUser aboutUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.aboutUser = aboutUser;
    }

//    @OneToMany(cascade = CascadeType.ALL)
//    @NonNull
//    private List<Profile> follower;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @NonNull
//    private List<Profile> following;
}

