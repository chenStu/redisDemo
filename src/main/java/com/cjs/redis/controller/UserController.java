package com.cjs.redis.controller;

import com.cjs.redis.entity.User;
import com.cjs.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author CJS
 * @description
 * @date 11:13 19/11/04
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAllUser")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @PostMapping("/saveUser")
    public List<User> saveUser(User user) {
        userService.saveUser(user);
        return userService.findAllUser();
    }

    @PostMapping("/findUserById")
    public Optional<User> findUserById(Integer id) {
        return userService.findUserById(id);
    }

    @PutMapping("/updateUser")
    public List<User> updateUser(User user) {
        userService.updateUser(user);
        return userService.findAllUser();
    }

    @DeleteMapping("/deleteUser")
    public List<User> deleteUser(Integer id) {
        userService.deleteUserById(id);
        return userService.findAllUser();
    }

}
