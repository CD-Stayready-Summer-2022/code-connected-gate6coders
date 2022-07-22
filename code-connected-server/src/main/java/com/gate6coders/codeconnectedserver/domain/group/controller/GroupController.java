package com.gate6coders.codeconnectedserver.domain.group.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;

public class GroupController {

=======
import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.group.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
public class GroupController {

    private GroupService groupService;

    @Autowired GroupController(GroupService groupService){
        this.groupService = groupService;
    }



>>>>>>> 7aad8db2b03e86c694ec89bff4a68bdebc3d2646
}
