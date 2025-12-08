package com.nagesh.service;

import com.nagesh.entity.User;

public interface UserService {
    boolean validateUser(String email, String password);
    public User saveUser(User user);
    public User getUser(String email);
    
    
}
