package com.example.car_shop.services;

import com.example.car_shop.model.User;
import com.example.car_shop.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UsersSeriveceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> findAllUsers() {
        return usersRepository.findAll();
    }
    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
    @Override
    public User save(User user) {
        return usersRepository.save(user);
    }
}