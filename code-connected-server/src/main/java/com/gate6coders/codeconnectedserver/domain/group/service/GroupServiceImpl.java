package com.gate6coders.codeconnectedserver.domain.group.service;

import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.group.repo.GroupRepo;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import com.gate6coders.codeconnectedserver.domain.profile.repo.ProfileRepo;

import java.util.List;
import java.util.Optional;

public class GroupServiceImpl implements GroupService {
    private ProfileRepo profileRepo;
    private GroupRepo groupRepo;

    @Override
    public Group create(Long userId, Long groupId, String groupName) {
        Profile admin = profileRepo.getReferenceById(userId);
        Optional<Group> optional = groupRepo.findById(groupId);
        Group group = optional.get();
        group.setAdmin(admin);
        group.setGroupName(groupName);
        return groupRepo.save(group);
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


