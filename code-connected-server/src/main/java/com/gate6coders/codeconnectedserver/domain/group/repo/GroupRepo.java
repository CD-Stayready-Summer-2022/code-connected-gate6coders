package com.gate6coders.codeconnectedserver.domain.group.repo;

import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;

import java.util.Optional;

public interface GroupRepo {
    Optional<Group> findById(Long id);
    Optional<Group> findByGroupName(String groupName);
}
