package com.wyl.docker.service;


import com.wyl.docker.entities.User;
import com.wyl.docker.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther yanl.wang
 * @date 2022/6/26
 **/

@Service
@Slf4j
public class UserService {
    public static final String CACHE_KEY_USER = "user:";

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    public void addUser(User user){
        //1.先插入 mysql 并成功
        int i = userMapper.insertSelective(user);

        if (i>0){
            //2.需要再次查询一下 mysql 将数据捞回来并 ok
            user = userMapper.selectByPrimaryKey(user.getId());
            //3.将捞出来的 user 存进 redis ，完成新增功能的数据一致性。
            String key = CACHE_KEY_USER+user.getId();
            redisTemplate.opsForValue().set(key,user);
        }
    }

    public User findUserById(Integer id){
        User user = null;
        String key = CACHE_KEY_USER+id;

        //1.先从 redis 里面查询，如果有直接返回结果，如果没有再去查询 mysql
        user = (User) redisTemplate.opsForValue().get(key);
        if (user == null){
            //2.redis 里面无，继续查询 mysql 
            user = userMapper.selectByPrimaryKey(id);
            if (user == null){
                //3.1  redis+mysql  都无数据
                //你具体细化，防止多次穿透，我们规定，记录下导致穿透的这个 key 回写 redis
                return user;

            }else {
                //3.2 mysql 有，需要将数据写回 redis ，保证下一次的缓存命中率
                redisTemplate.opsForValue().set(key,user);
            }
        }
        return user;
    }
}
