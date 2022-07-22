package com.gate6coders.codeconnectedserver.domain.education.model;

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
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String startDate;

    @NonNull
    private String endDate;

    @NonNull
    private String school;

    @NonNull
    private String degree;

    @NonNull
    private  String fieldOfStudy;
}
