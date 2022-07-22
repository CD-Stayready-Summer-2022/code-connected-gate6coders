package com.gate6coders.codeconnectedserver.domain.group.repo;

//<<<<<<< HEAD
import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface GroupRepo<admin> extends JpaRepository<Group, admin> {
    Optional<Group>findByAdmin(Profile profile, Profile admin);
    
    Optional<Group>findByGroup(String Group);

=======
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface GroupRepo extends CrudRepository<Group, UUID> {
    Optional<Group> findById(Long id);
    Optional<Group> findByGroupName(String groupName);
>>>>>>> 7aad8db2b03e86c694ec89bff4a68bdebc3d2646
}
