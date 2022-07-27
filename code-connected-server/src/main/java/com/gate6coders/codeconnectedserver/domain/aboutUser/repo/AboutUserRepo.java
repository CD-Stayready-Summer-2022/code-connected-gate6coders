package com.gate6coders.codeconnectedserver.domain.aboutUser.repo;

import com.gate6coders.codeconnectedserver.domain.aboutUser.model.AboutUser;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;

import java.util.Optional;

public interface AboutUserRepo {
    Optional<AboutUser> findByHeadLine(String profileHeadLine);
}
