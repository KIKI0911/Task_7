package com.kiki.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public User findUser(int id) {
        Optional<User> user_Id = this.userMapper.findById(id);
        if (user_Id.isPresent()) {
            return user_Id.get();
        } else {
            throw new UserNotFoundException("user:" + id + " not found");
        }
    }

    public User findUserFromAddress(int id, int addressId) {
        Optional<User> user_IdAndAddress = this.userMapper.findByIdAndAddressId(id,addressId);
        if (user_IdAndAddress.isPresent()) {
            return user_IdAndAddress.get();
        } else {
            throw new UserNotFoundException("user:" + id + " not found");
        }
    }
}
