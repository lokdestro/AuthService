package com.example.demo.Servicies;

import com.example.demo.Entities.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User Add(User u) {
        return userRepo.save(u);
    }

    public void Delete(Integer id) {
        userRepo.deleteById(id);
    }



}
