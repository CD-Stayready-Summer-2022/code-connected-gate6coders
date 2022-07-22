package com.gate6coders.codeconnectedserver.domain.group.service;
import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import java.util.List;

public interface GroupService {
<<<<<<< HEAD
=======
    Group create(Long userId, Long groupId, String groupName);
    Group getGroupById(Long id);
    List<Profile> getAllMembers(Long id);
>>>>>>> 7aad8db2b03e86c694ec89bff4a68bdebc3d2646

}
