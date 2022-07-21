package com.gate6coders.codeconnectedserver.aboutUser.model;

import com.gate6coders.codeconnectedserver.domain.education.model.Education;
import com.gate6coders.codeconnectedserver.domain.experience.model.Experience;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @NonNull
    private List<String> skills;

    @NonNull
    private List<Experience> experience;

    @NonNull
    private List<Education> education;
}
