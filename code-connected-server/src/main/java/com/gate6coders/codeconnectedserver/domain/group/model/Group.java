package com.gate6coders.codeconnectedserver.domain.group.model;

import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Table(name="groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String groupName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    @NonNull
    private Profile admin;

    @NonNull
    private String description;

    @ManyToMany(mappedBy = "groupMembers")
    Set<Profile> groups;


     @OneToMany(cascade = CascadeType.ALL, targetEntity = Profile.class)
     @JoinColumn(name = "group_id", referencedColumnName = "id")
     private List<Profile> groupMembers;
<<<<<<< HEAD
=======

>>>>>>> dde5ac5a0fc25c62ed027d5b39819237bccb0956
}
