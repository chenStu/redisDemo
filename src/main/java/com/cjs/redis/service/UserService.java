package com.cjs.redis.service;

import com.cjs.redis.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author CJS
 * @description
 * @date 11:02 19/11/04
 */
public interface UserService {

    List<User> findAllUser();

    void saveUser(User user);

    Optional<User> findUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);

}
