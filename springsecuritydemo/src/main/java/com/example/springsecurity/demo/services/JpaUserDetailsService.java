package com.example.springsecurity.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurity.demo.models.User;
import com.example.springsecurity.demo.repositories.UserRepository;

@Service
@Primary
public class JpaUserDetailsService implements UserDetailsService
{
    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> user = userRepo.findByUserName(username);
        if (user.isPresent())
            return new JpaUserDetails(user.get());
        else
            throw new UsernameNotFoundException("UserName " + username + " not found");
    }
}
