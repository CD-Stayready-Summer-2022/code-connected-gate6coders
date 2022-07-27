package com.gate6coders.codeconnectedserver.domain.group.service;
import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import java.util.List;

public interface GroupService {
    Group create(Group group);
    Group getGroupById(Long id);
    List<Profile> getAllMembers(Long id);

}
