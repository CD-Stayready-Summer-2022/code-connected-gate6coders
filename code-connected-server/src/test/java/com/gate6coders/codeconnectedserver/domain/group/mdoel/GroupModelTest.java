package com.gate6coders.codeconnectedserver.domain.group.mdoel;

import org.junit.jupiter.api.Assertions;
import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroupModelTest {

    private Group group1;
    private Group group2;

    private Profile profile1;
    private Profile profile2;

    private Group groupMember1;
    private Group groupMember2;

    @BeforeEach
    public void setup(){
        group1 = new Group();
        group2 = new Group();

        profile1 = new Profile();
        profile2 = new Profile();

        groupMember1 = new Group("DummyGroup",profile1,"This is a dummy group");
        groupMember2 = new Group("DummyGroup",profile2,"This is a dummy group");
        groupMember1.setId(1L);
        groupMember2.setId(2L);


    }
    @Test
    public void testGroupEquals() {
        Assertions.assertEquals(group1,group2);
    }
    @Test
    public void testGroupMembersEquals() {
        Assertions.assertEquals(groupMember1,groupMember2);
    }
    @Test
    public void testGroupMembersNotEquals() {
        Assertions.assertNotEquals(groupMember1,groupMember2);
    }

}