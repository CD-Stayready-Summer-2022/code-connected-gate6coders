package com.gate6coders.codeconnectedserver.domain.group.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String groupName;

    @NonNull
    private Profile admin;

    @NonNull
    private String description;

    @NonNull
    private List<Profile> groupMembers;

    //remember to add profile once profile class is complete
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
}
