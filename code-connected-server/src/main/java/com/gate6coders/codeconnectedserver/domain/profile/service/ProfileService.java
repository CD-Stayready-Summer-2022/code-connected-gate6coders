package com.gate6coders.codeconnectedserver.domain.profile.service;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ProfileNotFoundException;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceCreationException;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;

import java.util.List;

public interface ProfileService {
    Profile getById(Long id) throws ProfileNotFoundException;
    List<Profile> getProfiles();
    List<Profile> getAllFollowers();
    List<Profile> getAllFollowing();
    Profile create(Profile profile) throws ResourceCreationException;
    Profile update(Long id, Profile profile) throws ProfileNotFoundException;
    String follow(Long id1, Long id2);
    void delete(Long id) throws ProfileNotFoundException;
}
