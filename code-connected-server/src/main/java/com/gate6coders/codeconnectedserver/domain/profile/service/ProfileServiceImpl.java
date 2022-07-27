package com.gate6coders.codeconnectedserver.domain.profile.service;

import com.gate6coders.codeconnectedserver.domain.aboutUser.model.AboutUser;
import com.gate6coders.codeconnectedserver.domain.aboutUser.repo.AboutUserRepo;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceCreationException;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.gate6coders.codeconnectedserver.domain.group.education.model.Education;
import com.gate6coders.codeconnectedserver.domain.experience.model.Experience;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import com.gate6coders.codeconnectedserver.domain.profile.repo.ProfileRepo;
import com.gate6coders.codeconnectedserver.domain.skill.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{

    private ProfileRepo profileRepo;
    private AboutUserRepo aboutUserRepo;

    @Autowired
    public ProfileServiceImpl(ProfileRepo profileRepo, AboutUserRepo aboutUserRepo) {
        this.profileRepo = profileRepo;
        this.aboutUserRepo = aboutUserRepo;
    }

    @Override
    public Profile getById(Long id) throws ResourceNotFoundException {
        return profileRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile with id does not exist"));
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
        profile.setAboutUser(new AboutUser());
        return profileRepo.save(profile);
    }

    @Override
    public Profile update(Long id, Profile profile) throws ResourceNotFoundException {
        Profile savedProfile = getById(id);
        savedProfile.setFirstName(profile.getFirstName());
        savedProfile.setLastName(profile.getLastName());
        savedProfile.setEmail(profile.getEmail());
        savedProfile.setPassword(profile.getPassword());
        savedProfile.setAboutUser(profile.getAboutUser());
        return profileRepo.save(profile);
    }

    @Override
    public AboutUser getByHeadLine(String profileHeadLine) throws ResourceNotFoundException {
        return aboutUserRepo.findByHeadLine(profileHeadLine)
                .orElseThrow(() -> new ResourceNotFoundException("This headline does not exist"));
    }

    @Override
    public Profile updateEducation(Long profileId, Education education) throws ResourceNotFoundException {
        Profile profile = getById(profileId);
        AboutUser educationDetail = profile.getAboutUser();
        educationDetail.getEducation().add(education);
        return profileRepo.save(profile);
    }

    @Override
    public Profile updateExperiences(Long profileId, Experience experience) throws ResourceNotFoundException {
        Profile profile = getById(profileId);
        AboutUser experiencesDetail = profile.getAboutUser();
        experiencesDetail.getExperience().add(experience);
        return profileRepo.save(profile);
    }

    @Override
    public Profile updateSkills(Long profileId, Skill skill) {
        Profile profile = getById(profileId);
        AboutUser skillDetail = profile.getAboutUser();
        skillDetail.getSkills().add(skill.getSkill());
        return profileRepo.save(profile);
    }

    @Override
    public Profile updateHeadline(Long profileId, String profileHeadline) throws ResourceNotFoundException {
        Profile profile = getById(profileId);
        AboutUser headlineDetail = profile.getAboutUser();
        headlineDetail.setProfileHeadline(profileHeadline);
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
    public void delete(Long id) throws ResourceNotFoundException {
        Profile profile = getById(id);
        profileRepo.delete(profile);
    }
}
