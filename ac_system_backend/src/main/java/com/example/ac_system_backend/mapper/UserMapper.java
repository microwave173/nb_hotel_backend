package com.example.ac_system_backend.mapper;

import com.example.ac_system_backend.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user (id, name, password, tag) VALUES (#{id}, #{name}, #{password}, #{tag})")
    public void insertUser(User user);

    @Select("SELECT * FROM user WHERE name=#{name}")
    public User getUserByName(String name);
}
