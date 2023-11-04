package com.example.car_shop.sequrity.details;

import com.example.car_shop.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {
    private User user;
    public UserDetailsImpl(User user) {
        this.user = user;

    }
    public Long getId() {
        return user.getId();
    }
    public String getRole() {
        return user.getRole().toString();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole().toString());
        return Collections.singleton(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return user.getHashPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    //просрочен
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //не заблокирован
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}