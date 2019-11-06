package com.cjs.redis.service.impl;

import com.cjs.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author CJS
 * @description
 * @date 10:13 19/11/04
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @param key     所存关键字
     * @param obj     所存对象
     * @param timeout 过期时间
     * @author CJS
     * @description 保存到redis以及过期时间
     * @date 10:10 19/11/04
     */
    @Override
    public void setObj(String key, Object obj, long timeout) {

        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key, obj, timeout, TimeUnit.SECONDS);

    }

    /**
     * @param key 取值关键字
     * @return java.lang.Object
     * @author CJS
     * @description 从redis中取值
     * @date 10:13 19/11/04
     */
    @Override
    public Object getObj(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * @param key
     * @return void
     * @author CJS
     * @description 从redis中删除值
     * @date 11:29 19/11/04
     */
    @Override
    public void deleteObj(String key) {
        redisTemplate.delete(key);
    }
}
