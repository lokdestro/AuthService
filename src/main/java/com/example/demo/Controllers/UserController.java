package com.example.demo.Controllers;

import com.example.demo.Entities.User;
import com.example.demo.Servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups/{UserId}/users")
public class UserController {
    private final UserService srv;

    @Autowired
    public UserController(UserService srv) {
        this.srv = srv;
    }

    @PostMapping
    public ResponseEntity<User> Add(@PathVariable("UserId") String UserId, @RequestBody User user) {
        System.out.println("Adding user " + UserId);
        user.setUserId(Integer.parseInt(UserId));
        System.out.println(user.getUserName());
        System.out.println(user.getAge());
        return ResponseEntity.ok(srv.Add(user));
    }


    @DeleteMapping("/{Id}")
    public void Delete(@PathVariable("UserId") String UserId,@PathVariable("Id") String Id) {
        System.out.println("Deleting user " + UserId);
        srv.Delete(Integer.parseInt(Id));
    }

}
