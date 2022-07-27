package com.gate6coders.codeconnectedserver.domain.profile.controller;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ProfileNotFoundException;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.gate6coders.codeconnectedserver.domain.group.education.model.Education;
import com.gate6coders.codeconnectedserver.domain.experience.model.Experience;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import com.gate6coders.codeconnectedserver.domain.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;

    }

    @PostMapping
    public ResponseEntity<Profile> createProfile (@RequestBody Profile profile) throws ProfileNotFoundException {
        profile = profileService.create(profile);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Profile>> getAllProfiles() {
        Iterable<Profile> profiles = profileService.getProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Profile> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Profile profile = profileService.getById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping("{id}")
    public ResponseEntity<Profile> updatedProfile(@PathVariable("id") Long id, @RequestBody Profile profileDetail) throws ResourceNotFoundException {
        Profile profile = profileService.update(id, profileDetail);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProfile(@PathVariable("id") Long id) throws ResourceNotFoundException {
        profileService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("{id}/about/education")
    public ResponseEntity<Profile> updateEducation(@PathVariable("id") Long id, @RequestBody Education educationDetail) throws ResourceNotFoundException {
        Profile education = profileService.updateEducation(id, educationDetail);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("{id}/about/experiences")
    public ResponseEntity<Profile> updateExperiences(@PathVariable("id") Long id, @RequestBody Experience experienceDetail) throws ResourceNotFoundException {
        Profile experience = profileService.updateExperiences(id, experienceDetail);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
