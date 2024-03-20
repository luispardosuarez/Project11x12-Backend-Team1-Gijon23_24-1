package com.x12.project11x12.users;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public List<User> getAll() {
        List<User> users = repository.findAll();
        return users;
    }
    public User save(User type) {
        User newUser = new User();
        repository.save(newUser);
        return newUser;
    }

}