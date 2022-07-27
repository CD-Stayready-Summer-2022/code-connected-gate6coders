package com.gate6coders.codeconnectedserver.domain.profile.service;

import com.gate6coders.codeconnectedserver.domain.aboutUser.model.AboutUser;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceCreationException;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.gate6coders.codeconnectedserver.domain.education.model.Education;
import com.gate6coders.codeconnectedserver.domain.experience.model.Experience;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import com.gate6coders.codeconnectedserver.domain.skill.model.Skill;

import java.util.List;

public interface ProfileService {
    Profile getById(Long id) throws ResourceNotFoundException;
    List<Profile> getProfiles();
    List<Profile> getAllFollowers();
    List<Profile> getAllFollowing();
    Profile create(Profile profile) throws ResourceCreationException;
    Profile update(Long id, Profile profile) throws ResourceNotFoundException;
    AboutUser getByHeadLine(String profileHeadLine) throws ResourceNotFoundException;
    Profile updateEducation(Long profileId, Education education) throws ResourceNotFoundException;
    Profile updateExperiences(Long profileId, Experience experience) throws ResourceNotFoundException;
    Profile updateSkills (Long profileId, Skill skill);
    Profile updateHeadline(Long profileId, String profileHeadline) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
