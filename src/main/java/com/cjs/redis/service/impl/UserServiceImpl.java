package com.cjs.redis.service.impl;

import com.cjs.redis.entity.User;
import com.cjs.redis.repository.UserRepository;
import com.cjs.redis.service.RedisService;
import com.cjs.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author CJS
 * @description
 * @date 11:05 19/11/04
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisService redisService;

    @Override
    public List<User> findAllUser() {
        List<User> userList = (List<User>) redisService.getObj("allUser");
        if (userList == null) {
            log.info("---数据库查询---");
            userList = userRepository.findAll();
            // 存入redis
            redisService.setObj("allUser", userList, 60 * 2 * 1000);
        }
        return userList;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
        redisService.deleteObj("allUser");
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
        redisService.deleteObj("allUser");
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
        redisService.deleteObj("allUser");
    }

}
