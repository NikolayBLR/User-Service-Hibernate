package org.example.service;

import org.example.controller.UserController;
import org.example.dto.RequestUser;
import org.example.dto.ResponseUser;
import org.example.entity.User;
import org.example.mapper.UserMapperDTO;
import org.example.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private final UserMapperDTO userMapperDTO;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapperDTO = new UserMapperDTO();
    }

    public RequestUser saveUser(ResponseUser responseuser) {
        User user1 = userMapperDTO.UserMapResponse(responseuser);
        User user2 = userRepository.saveUser(user1);
        RequestUser requestUser = userMapperDTO.UserMapRequest(user2);
        return requestUser;
    }

    public RequestUser getUser(Integer id) {
        User user = userRepository.getUser(id);
        RequestUser requestUser = userMapperDTO.UserMapRequest(user);
        return requestUser;
    }

    public RequestUser deleteUser(Integer id) {
        User user = userRepository.deleteUser(id);
        RequestUser requestUser = userMapperDTO.UserMapRequest(user);
        return requestUser;
    }

    public RequestUser updateUser(Integer id, ResponseUser user) {
        User user1 = userMapperDTO.UserMapResponse(user);
        User user2 = userRepository.updateUser(id,user1);
        RequestUser requestUser = userMapperDTO.UserMapRequest(user2);
        return requestUser;
    }
}
