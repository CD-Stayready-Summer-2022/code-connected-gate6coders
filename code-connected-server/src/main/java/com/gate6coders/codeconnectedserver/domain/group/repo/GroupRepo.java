package com.gate6coders.codeconnectedserver.domain.group.repo;

//<<<<<<< HEAD
import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface GroupRepo<admin> extends JpaRepository<Group, admin> {
    Optional<Group>findByAdmin(Profile profile, Profile admin);
    
    Optional<Group>findByGroup(String Group);

}
