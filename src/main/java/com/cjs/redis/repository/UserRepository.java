package com.cjs.redis.repository;

import com.cjs.redis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author CJS
 * @description
 * @date 10:47 19/11/04
 */
public interface UserRepository extends JpaRepository<User, Integer> {


}
