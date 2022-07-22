package com.gate6coders.codeconnectedserver.domain.group.repo;
import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface GroupRepo extends JpaRepository<Group, Long> {
    Optional<Group> findByAdmin(Long adminId);
    Optional<Group> findByGroupName(String groupName);
}
