package com.example.casestudymd3.service;

import com.example.casestudymd3.model.User;
import com.example.casestudymd3.repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements IObjectService<User>{
    private final UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(int id, User user) {
        userRepository.update(id,user);
    }
    @Override
    public void remove(int id) {
        userRepository.remove(id);
    }
    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }
}
