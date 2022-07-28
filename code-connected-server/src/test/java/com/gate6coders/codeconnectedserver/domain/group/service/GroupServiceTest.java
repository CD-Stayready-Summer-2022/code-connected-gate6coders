package com.gate6coders.codeconnectedserver.domain.group.service;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.group.repo.GroupRepo;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GroupServiceTest {
    @Autowired
    GroupService groupService;

    @MockBean
    GroupRepo groupRepo;

    private Group mockGroup1;

    private Group saveGroup1;

    @BeforeEach
    public void setup(){
        mockGroup1 = new Group("fakeGroup",new Profile(),"fake description");
        saveGroup1 = new Group("fakeGroup",new Profile(),"fake description");
        saveGroup1.setId(1L);


    }
    @Test
    @DisplayName("Get by id - failure")
    public void getByIdTest02(){
        BDDMockito.doReturn(Optional.empty()).when(groupRepo).findById(ArgumentMatchers.any());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            groupService.getGroupById(1L);
        });
    }
    @Test
    @DisplayName("Get messages by sender")
    public void getMessageBySenderTest01(){
        List<Group> groups = new ArrayList<>();
        groups.add(saveGroup1);
        BDDMockito.doReturn(groups).when(groupRepo).findById(ArgumentMatchers.any());
        Iterable<Group> group = (Iterable<Group>) groupService.getGroupById(1L);
        Assertions.assertTrue(messagesBySender.iterator().hasNext());
    }

}