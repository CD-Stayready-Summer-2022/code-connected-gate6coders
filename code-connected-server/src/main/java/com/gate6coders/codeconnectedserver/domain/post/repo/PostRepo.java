package com.gate6coders.codeconnectedserver.domain.post.repo;

import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.Optional;

public interface PostRepo extends JpaRepository<Profile,Long> {
    Optional<Profile> findBySender(Long id);
    Optional<Date> findDate(Integer Time);


}
