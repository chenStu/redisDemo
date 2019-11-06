package com.cjs.redis.service;

/**
 * @author CJS
 * @description
 * @date 10:10 19/11/04
 */
public interface RedisService {

    /**
     * @param key     所存关键字
     * @param obj     所存对象
     * @param timeout 过期时间
     * @author CJS
     * @description 保存到redis以及过期时间
     * @date 10:10 19/11/04
     */
    void setObj(String key, Object obj, long timeout);

    /**
     * @param key 关键字
     * @return java.lang.Object
     * @author CJS
     * @description 从redis中取值
     * @date 10:13 19/11/04
     */
    Object getObj(String key);

    /**
     * @param key
     * @return void
     * @author CJS
     * @description 从redis中删除值
     * @date 11:29 19/11/04
     */
    void deleteObj(String key);
}
