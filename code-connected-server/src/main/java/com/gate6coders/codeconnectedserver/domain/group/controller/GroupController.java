package com.gate6coders.codeconnectedserver.domain.group.controller;


import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.group.service.GroupService;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

public class GroupController {
import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.group.service.GroupService;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import java.util.List;

    public class GroupController {

        private GroupService groupService;

        @Autowired
        GroupController(GroupService groupService) {
            this.groupService = groupService;
        }

        @ShellMethod("Create a new Group")
        public String createNewGroup(@ShellOption({"-U", "--groupId"}) Long id,
                                     @ShellOption({"-N", "--name"}) String groupName) {
            Group group = new Group();
            groupService.create(id, group, groupName);
            return (String.format("Group names %s has been created", groupName));

        }

        @ShellMethod("get group by id")
        public Group getGroupById(@ShellOption({"-U", "--groupId"}) Long id) {
            return groupService.getGroupById(id);

        }

        @ShellMethod("get all members")
        public List<Profile> getAllMembers(@ShellOption({"-U", "--groupId"}) Long id) {
            return groupService.getAllMembers(id);
        }


    }
}
