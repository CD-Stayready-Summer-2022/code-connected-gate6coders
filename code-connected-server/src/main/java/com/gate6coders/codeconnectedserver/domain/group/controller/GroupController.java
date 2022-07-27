package com.gate6coders.codeconnectedserver.domain.group.controller;

import com.gate6coders.codeconnectedserver.domain.group.model.Group;
import com.gate6coders.codeconnectedserver.domain.group.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {
    private GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }
    @PostMapping
    public ResponseEntity<Group> createGroup (@RequestBody Group group){
        Group groupToSave = groupService.create(group);
        return new ResponseEntity<>(groupToSave, HttpStatus.CREATED);

    }
    @GetMapping("{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable("id") Long id) {
        Group group = groupService.getGroupById(id);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }
}








