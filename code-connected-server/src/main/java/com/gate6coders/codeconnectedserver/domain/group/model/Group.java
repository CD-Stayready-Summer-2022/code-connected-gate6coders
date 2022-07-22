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


     @OneToMany(cascade = CascadeType.ALL, targetEntity = Profile.class)
     @JoinColumn(name = "group_id", referencedColumnName = "id")
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

//    @Override
//    public String toString() {
//        return "Group{" +
//                "id=" + id +
//                ", groupName='" + groupName + '\'' +
//                ", admin=" + admin +
//                ", description='" + description + '\'' +
//                ", groupMembers=" + groupMembers +
//                '}';
//    }


}
