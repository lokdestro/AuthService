package com.example.demo.Controllers;

import com.example.demo.Entities.Group;
import com.example.demo.Entities.User;
import com.example.demo.Servicies.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService srv;

    @Autowired
    public GroupController(GroupService srv) {
        this.srv = srv;
    }

    @PostMapping
    public ResponseEntity<Group> Create() {
        System.out.println("create");
        return ResponseEntity.ok(srv.Create());
    }


    @GetMapping("/{Id}")
    public ResponseEntity<List<User>> Get(@PathVariable("Id") String Id) {
        System.out.println("get");
        return ResponseEntity.ok(srv.Get(Integer.parseInt(Id)));
    }
}

