package org.example.controller;

import org.example.dto.RequestUser;
import org.example.dto.ResponseUser;
import org.example.entity.User;
import org.example.service.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RequestUser saveUser(ResponseUser user) {
        return userService.saveUser(user);
    }

    public RequestUser getUser(Integer id) {
        return userService.getUser(id);
    }

    public RequestUser deleteUser(Integer id) {
        return userService.deleteUser(id);
    }

    public RequestUser updateUser(Integer id, ResponseUser user) {
        return userService.updateUser(id, user);
    }

}
