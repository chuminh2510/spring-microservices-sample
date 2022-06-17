package com.example.userservice.service;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepo;

    @Override
    public User save(User data) {
        return userRepo.save(data);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User update(User data) {
        return userRepo.save(data);
    }

    @Override
    public int delete(User data) {
        userRepo.delete(data);
        return 0;
    }

    @Override
    public User findById(Integer id) {
        return userRepo.findById(id).get();
    }

    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
}
