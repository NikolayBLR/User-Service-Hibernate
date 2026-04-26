package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User saveUser(User user) {
        return userService.saveUser(user);
    }

    public User getUser(Integer id) {
        return userService.getUser(id);
    }

    public User deleteUser(Integer id) {
        return userService.deleteUser(id);
    }

    public User updateUser(Integer id, User user) {
        return userService.updateUser(id, user);
    }

}
