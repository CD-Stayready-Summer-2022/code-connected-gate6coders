package com.gate6coders.codeconnectedserver.domain.group.service;

import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.group.repo.GroupRepo;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import com.gate6coders.codeconnectedserver.domain.profile.repo.ProfileRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    private ProfileRepo profileRepo;
    private GroupRepo groupRepo;

    @Override
    public void create(Long userId, Group group, String groupName) {
        Profile admin = profileRepo.getReferenceById(userId);
        groupRepo.save(group);
    }

    @Override
    public Group getGroupById(Long id) {
        Optional<Group> optional = groupRepo.findById(id);
        return optional.get();
    }

    @Override
    public List<Profile> getAllMembers(Long id) {
        Optional<Group> optional = groupRepo.findById(id);
        return optional.get().getGroupMembers();
    }
}


