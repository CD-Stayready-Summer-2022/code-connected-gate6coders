package com.gate6coders.codeconnectedserver.domain.aboutUser.model;

import com.gate6coders.codeconnectedserver.domain.group.education.model.Education;
import com.gate6coders.codeconnectedserver.domain.experience.model.Experience;
import com.gate6coders.codeconnectedserver.domain.skill.model.Skill;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class AboutUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String about;

    @NonNull
    private String  profileHeadline;

    @OneToMany(targetEntity = Skill.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "about_id", referencedColumnName = "id")
    @NonNull
    private List<String> skills;

    @OneToMany(targetEntity = Experience.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "about_id", referencedColumnName = "id")
    @NonNull
    private List<Experience> experience;

    @OneToMany(targetEntity = Education.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "about_id", referencedColumnName = "id")
    @NonNull
    private List<Education> education;
}
