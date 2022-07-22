package com.gate6coders.codeconnectedserver.mock;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ProfileNotFoundException;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import com.gate6coders.codeconnectedserver.domain.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mockprofile")
public class MockProfileController {

    private ProfileService profileService;

    @Autowired
    public MockProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable("id") Long id) throws ProfileNotFoundException {
        Profile profile = profileService.getById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Profile>> getAllProfiles(){
        Iterable<Profile> profiles = profileService.getProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
}
