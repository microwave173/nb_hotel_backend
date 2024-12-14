package com.example.ac_system_backend.service;

import com.example.ac_system_backend.pojo.User;

public interface IUserService {
    public void addUser(User user);

    public User getUserByName(String name);

    public boolean checkUser(String token);

    public User getUserByToken(String token);
}
