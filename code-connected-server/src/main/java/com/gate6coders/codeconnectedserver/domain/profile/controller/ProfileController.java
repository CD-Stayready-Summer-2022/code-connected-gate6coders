package com.gate6coders.codeconnectedserver.domain.profile.controller;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ProfileNotFoundException;
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
    public ResponseEntity<Profile> getById(@PathVariable("id") Long id) throws ProfileNotFoundException {
        Profile profile = profileService.getById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping("{id}")
    public ResponseEntity<Profile> updatedProfile(@PathVariable("id") Long id, @RequestBody Profile profileDetail) throws ProfileNotFoundException {
        Profile profile = profileService.update(id, profileDetail);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProfile(@PathVariable("id") Long id) throws ProfileNotFoundException {
        profileService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
