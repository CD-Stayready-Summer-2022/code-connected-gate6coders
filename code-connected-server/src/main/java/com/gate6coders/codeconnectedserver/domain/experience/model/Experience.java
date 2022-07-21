package com.gate6coders.codeconnectedserver.domain.experience.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private ExperienceStatus experienceStatus;

    @NonNull
    private String companyName;

    @NonNull
    private String startDate;

    @NonNull
    private String endDate;

    @NonNull
    private String industry;

    @NonNull
    private String description;
}
