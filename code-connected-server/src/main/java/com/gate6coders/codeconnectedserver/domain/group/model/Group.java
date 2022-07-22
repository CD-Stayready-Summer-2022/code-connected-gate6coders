package com.gate6coders.codeconnectedserver.domain.group.model;

import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//<<<<<<< HEAD
import javax.persistence.*;
//=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//>>>>>>> 1ec414fb12785b4c0eef8d472a2e09823489c2dc
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Group {

//<<<<<<< HEAD

//=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "id")
    @NonNull
    private Profile admin;

    @NonNull
    private String description;

    @OneToMany
    private List<Profile> groupMembers;


    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", admin=" + admin +
                ", description='" + description + '\'' +
                ", groupMembers=" + groupMembers +
                '}';
    }
//>>>>>>> 109c75a61c14cffaa9c9701d5fffe9bd70d9c22b
}
