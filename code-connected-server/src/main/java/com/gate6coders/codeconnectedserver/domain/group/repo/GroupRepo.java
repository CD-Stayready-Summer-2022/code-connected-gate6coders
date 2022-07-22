package com.gate6coders.codeconnectedserver.domain.group.repo;

import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface GroupRepo extends CrudRepository<Group, UUID> {
    Optional<Group> findById(Long id);
    Optional<Group> findByGroupName(String groupName);
}
