package com.gate6coders.codeconnectedserver.domain.experience.model;

import lombok.*;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
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
