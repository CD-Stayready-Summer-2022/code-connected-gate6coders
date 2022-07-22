package com.gate6coders.codeconnectedserver.domain.profile.service;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ProfileNotFoundException;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceCreationException;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import com.gate6coders.codeconnectedserver.domain.profile.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{

    private ProfileRepo profileRepo;

    @Autowired
    public ProfileServiceImpl(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public Profile getById(Long id) throws ProfileNotFoundException {
        return profileRepo.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile with id does not exist"));
    }

    @Override
    public List<Profile> getProfiles() {
        return profileRepo.findAll();
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
    public Profile create(Profile profile) throws ResourceCreationException {
        Optional<Profile> optional = profileRepo.findByUserName(profile.getUserName());
        if (optional.isPresent())
            throw new ResourceCreationException("Profile with this user name does not exist");
        return profileRepo.save(profile);
    }

    @Override
    public Profile update(Long id, Profile profile) throws ProfileNotFoundException {
        Profile savedProfile = getById(id);
        savedProfile.setFirstName(profile.getFirstName());
        savedProfile.setLastName(profile.getLastName());
        savedProfile.setEmail(profile.getEmail());
        savedProfile.setPassword(profile.getPassword());
        savedProfile.setAboutUser(profile.getAboutUser());
        return profileRepo.save(profile);
    }

//    @Override
//    public String follow(Long id1, Long id2) {
//        Optional<Profile> optfollowedProfile = profileRepo.findById(id1);
//        Optional<Profile> optfollowerProfile = profileRepo.findById(id2);
//
//        Profile followedProfile = optfollowedProfile.get();
//        Profile followerProfile = optfollowerProfile.get();
//
//        //follower list
//        List<Profile> followerList = followedProfile.getFollower();
//        followerList.add(followerProfile);
//        followedProfile.setFollower(followerList);
//
//        profileRepo.save(followedProfile);
//        profileRepo.save(followerProfile);
//        return String.format("You followed %s", followedProfile.getUserName());
//    }

    @Override
    public void delete(Long id) throws ProfileNotFoundException {
        Profile profile = getById(id);
        profileRepo.delete(profile);
    }
}
