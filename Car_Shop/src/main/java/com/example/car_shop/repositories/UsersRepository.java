package com.example.car_shop.repositories;

import com.example.car_shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
