package com.gate6coders.codeconnectedserver.domain.profile.service;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ProfileNotFoundException;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;

import java.util.List;

public class ProfileServiceImpl implements ProfileService{
    @Override
    public Profile getById(Long id) throws ProfileNotFoundException {
        return null;
    }

    @Override
    public List<Profile> getProfiles() {
        return null;
    }

    @Override
    public List<Profile> getAllFollowers() {
        return null;
    }

    @Override
    public List<Profile> getAllFollowing() {
        return null;
    }

    @Override
    public Profile create(Profile profile) throws ProfileNotFoundException {
        return null;
    }

    @Override
    public Profile update(Long id, Profile profile) throws ProfileNotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) throws ProfileNotFoundException {

    }
}
