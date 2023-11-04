package com.example.car_shop.sequrity.details;

import com.example.car_shop.model.User;
import com.example.car_shop.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("customUserDetailService")
//получение пользователя
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserDetailsImpl(user);
    }
}
