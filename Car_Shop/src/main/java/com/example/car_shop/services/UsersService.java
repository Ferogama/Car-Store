package com.example.car_shop.services;

import com.example.car_shop.model.User;

import java.util.List;

public interface UsersService {
    List<User> findAllUsers();
    void deleteUser(Long id);
    User save(User user);
}
