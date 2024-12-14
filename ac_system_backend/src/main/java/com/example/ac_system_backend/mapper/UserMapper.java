package com.example.ac_system_backend.mapper;

import com.example.ac_system_backend.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * UserMapper 接口用于操作与用户相关的数据库表。
 * 提供用户的注册和按用户名查询功能。
 */
@Mapper
public interface UserMapper {

    /**
     * 插入一条新的用户记录到数据库中。
     * 用户信息包括用户 ID、用户名、密码、角色标签和房间编号。
     *
     * @param user 用户对象，包含需要插入的数据字段
     */
    @Insert("INSERT INTO user (id, name, password, tag, roomId) VALUES (#{id}, #{name}, #{password}, #{tag}, #{room_id})")
    public void insertUser(User user);

    /**
     * 根据用户名查询用户的详细信息。
     * 用于验证用户是否已注册或获取用户的其他信息。
     *
     * @param name 用户名
     * @return 返回与用户名对应的用户对象，如果用户不存在则返回 null
     */
    @Select("SELECT * FROM user WHERE name=#{name}")
    public User getUserByName(String name);
}
