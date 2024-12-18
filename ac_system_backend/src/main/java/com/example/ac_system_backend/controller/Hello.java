package com.example.ac_system_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("api/hello")
//    @CrossOrigin(origins = "*")
    public String hello(@CookieValue("token") String token){
        return token;
    }
}
