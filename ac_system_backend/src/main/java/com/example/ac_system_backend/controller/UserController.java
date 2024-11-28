package com.example.ac_system_backend.controller;

import com.example.ac_system_backend.pojo.User;
import com.example.ac_system_backend.service.IUserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping("api/submit")
    public String submit(@RequestBody User user){
        try{
            user.setTag("customer");
            iUserService.addUser(user);
        }
        catch (Exception e){
            return "failed";
        }
        return "success";
    }

    @PostMapping("api/login")
    public String login(@RequestBody User user, HttpServletResponse response) {
        User user1 = iUserService.getUserByName(user.getName());
        if (user1 == null) {
            return "name not found";
        }
        if (user1.getPassword().equals(user.getPassword())) {
            Cookie cookie = new Cookie("token", user1.getName() + ":" + user1.getPassword()); // token 省略为 name + pwd
            cookie.setPath("/"); // 设置为根路径，使所有路径都能访问
            cookie.setMaxAge(360 * 60 * 60 * 24); // 360 天
            response.addCookie(cookie);

            return "success";
        } else {
            return "failed";
        }
    }
}
