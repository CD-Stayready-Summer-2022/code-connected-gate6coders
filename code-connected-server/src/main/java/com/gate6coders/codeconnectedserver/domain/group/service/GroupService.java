package com.gate6coders.codeconnectedserver.domain.group.service;
import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import java.util.List;

public interface GroupService {
    void create(Long userId, Group group, String groupName);
    Group getGroupById(Long id);
    List<Profile> getAllMembers(Long id);

}
