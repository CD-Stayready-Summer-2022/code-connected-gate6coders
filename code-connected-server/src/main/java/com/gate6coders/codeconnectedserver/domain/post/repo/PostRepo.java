package com.gate6coders.codeconnectedserver.domain.post.repo;

import com.gate6coders.codeconnectedserver.domain.post.model.Post;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepo extends JpaRepository<Profile,Long> {
//    Optional<Post> findByCreator(Long id);
}
