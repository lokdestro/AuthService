package com.example.demo.Servicies;

import com.example.demo.Entities.Group;
import com.example.demo.Entities.User;
import com.example.demo.repositories.GroupRepo;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private UserRepo userRepo;

    public Group Create () {
        return groupRepo.save(new Group());
    }

    public List<User> Get(int id) {
        System.out.println(id);
        Optional<Group> group = groupRepo.findById(id);
        if (group.isPresent()) {
            return userRepo.findByGroupId(group.get().getId());
        }

        return List.of();
    }
}
