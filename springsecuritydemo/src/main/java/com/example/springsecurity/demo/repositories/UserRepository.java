package com.example.springsecurity.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.springsecurity.demo.models.User;

public interface UserRepository extends CrudRepository<User, Long>
{
    Optional<User> findByUserName(String userName);
}
