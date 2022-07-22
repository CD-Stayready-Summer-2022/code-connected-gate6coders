package com.gate6coders.codeconnectedserver.domain.group.service;
import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import java.util.List;

public interface GroupService {
    Group create(Long userId, Long groupId, String groupName);
    Group getGroupById(Long id);
    List<Profile> getAllMembers(Long id);

}
