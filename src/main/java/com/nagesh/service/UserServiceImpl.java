package com.nagesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagesh.entity.User;
import com.nagesh.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public boolean validateUser(String email, String password) {
        User user = userRepo.findByEmailAndPassword(email, password);
        return user != null; 
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUser(String email) {
        return userRepo.findByEmail(email);
    }

	
}
