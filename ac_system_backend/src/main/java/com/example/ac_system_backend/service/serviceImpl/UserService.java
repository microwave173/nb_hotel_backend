package com.example.ac_system_backend.service.serviceImpl;

import com.example.ac_system_backend.mapper.UserMapper;
import com.example.ac_system_backend.pojo.User;
import com.example.ac_system_backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }
    @Override
    public User getUserByName(String name){
        return userMapper.getUserByName(name);
    }

    @Override
    public boolean checkUser(String token){
        String[] namePassword = token.split(":");
        User user = userMapper.getUserByName(namePassword[0]);
        return user != null && user.getPassword().equals(namePassword[1]);
    }

    @Override
    public User getUserByToken(String token){
        String[] namePassword = token.split(":");
        return userMapper.getUserByName(namePassword[0]);
    }
}
