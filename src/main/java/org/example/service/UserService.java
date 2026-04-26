package org.example.service;

import org.example.entity.User;
import org.example.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public User getUser(Integer id) {
        return userRepository.getUser(id);
    }

    public User deleteUser(Integer id) {
        return userRepository.deleteUser(id);
    }

    public User updateUser(Integer id, User user) {
        return userRepository.updateUser(id, user);
    }
}
