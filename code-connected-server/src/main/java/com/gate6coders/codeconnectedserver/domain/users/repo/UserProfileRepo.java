package com.gate6coders.codeconnectedserver.domain.users.repo;

import com.gate6coders.codeconnectedserver.domain.users.models.UserProfile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserProfileRepo extends CrudRepository<UserProfile, String> {
    Optional<UserProfile> findByEmail(String email);
}
