package com.example.car_shop.services;

import com.example.car_shop.dto.UserForm;
import com.example.car_shop.model.User;
import com.example.car_shop.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



//BEAN
@Component
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void signUp(UserForm form) {
        User newUser = User.builder()
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .role(User.Role.USER)
                .build();
        usersRepository.save(newUser);
    }
}
