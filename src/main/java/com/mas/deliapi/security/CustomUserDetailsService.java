package com.mas.deliapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles=null;
        if(username.equals("admin"))
        {
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User("admin", "$2y$12$I0Di/vfUL6nqwVbrvItFVOXA1L9OW9kLwe.1qDPhFzIJBpWl76PAe",
                    roles);
        }
        else if(username.equals("user"))
        {
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            return new User("user", "$2y$12$VfZTUu/Yl5v7dAmfuxWU8uRfBKExHBWT1Iqi.s33727NoxHrbZ/h2",
                    roles);
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
