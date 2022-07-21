package com.gate6coders.codeconnectedserver.domain.profile.repo;

import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Profile,Long> {
    Optional<Profile> findById(Long id);
    Optional<Profile> findByUserName(String userName);

}
