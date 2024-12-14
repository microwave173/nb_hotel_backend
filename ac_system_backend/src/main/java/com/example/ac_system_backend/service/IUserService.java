package com.example.ac_system_backend.service;

import com.example.ac_system_backend.pojo.User;

/**
 * IUserService 接口定义了与用户管理相关的核心业务逻辑。
 * 提供用户的注册、查询、认证和基于 Token 获取用户信息的功能。
 */
public interface IUserService {

    /**
     * 添加一个新的用户。
     * 用于用户注册时，将用户信息存储到系统中。
     *
     * @param user 用户对象，包含用户名、密码和其他用户属性
     */
    public void addUser(User user);

    /**
     * 根据用户名查询用户信息。
     * 用于检查用户名是否存在或获取用户的详细信息。
     *
     * @param name 用户名
     * @return 返回与该用户名对应的用户对象，如果用户不存在则返回 null
     */
    public User getUserByName(String name);

    /**
     * 检查用户 Token 的合法性。
     * 用于验证用户的身份是否有效，例如在访问受保护资源时。
     *
     * @param token 用户认证的 Token
     * @return 返回 true 表示 Token 有效，false 表示无效
     */
    public boolean checkUser(String token);

    /**
     * 根据 Token 获取用户信息。
     * 用于从认证 Token 中解析并获取对应的用户信息。
     *
     * @param token 用户认证的 Token
     * @return 返回与该 Token 对应的用户对象，如果 Token 无效则返回 null
     */
    public User getUserByToken(String token);
}
