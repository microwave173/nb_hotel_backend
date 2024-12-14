package com.example.ac_system_backend.controller;

import com.example.ac_system_backend.pojo.User;
import com.example.ac_system_backend.service.IUserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserService iUserService;

    /**
     * 用户注册接口。
     * 接收来自请求体的用户对象，为用户分配默认标签“customer”，
     * 并通过业务层将用户信息保存到数据库。
     *
     * @param user 请求体中的用户对象
     * @return 注册成功返回 "success"，失败返回 "failed"
     */
    @PostMapping("api/submit")
//    @CrossOrigin(origins = "*")
    public String submit(@RequestBody User user){
//        try{
//            user.setTag("customer");
//            iUserService.addUser(user);
//        }
//        catch (Exception e){
//            System.out.println(e.toString());
//            return "failed";
//        }
        user.setTag("customer");
        iUserService.addUser(user);
        return "success";
    }

    /**
     * 用户登录接口。
     * 验证用户登录信息，登录成功后生成一个基于用户名和密码的 token 并通过 HTTP Cookie 返回给客户端。
     *
     * @param user     请求体中的用户对象，包含用户名和密码
     * @param response HttpServletResponse，用于添加 Cookie 到响应中
     * @return 如果登录成功返回 "success"，用户名不存在返回 "name not found"，密码错误返回 "failed"
     */
    @PostMapping("api/login")  // trans ok
//    @CrossOrigin(origins = "*")
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
