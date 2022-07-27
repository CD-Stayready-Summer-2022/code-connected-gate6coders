package com.gate6coders.codeconnectedserver.domain.aboutUser.repo;

import com.gate6coders.codeconnectedserver.domain.aboutUser.model.AboutUser;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AboutUserRepo extends JpaRepository<AboutUser, Long> {
    Optional<AboutUser> findByProfileHeadline(String profileHeadline);
}
