package com.hand.springbootmybatis;

import com.hand.springbootmybatis.entity.Account;
import com.hand.springbootmybatis.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootMybatisApplicationTests {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate; // k-v都是字符串

    @Autowired
    RedisTemplate redisTemplate; // k-v都是对象

    @Autowired
    RedisTemplate myRedisTemplate;

    /**
     * String (字符串)、List(列表)、Set(集合)、Hash（散列）、ZSet(有序集合)
     * opsForValue()
     * opsForList()
     * opsForSet()
     * opsForHash()
     * opsForZSet()
     */

    @Test
    void test1() {
        // 保存字符串
        stringRedisTemplate.opsForValue().append("msg", "hello");
        stringRedisTemplate.opsForList().leftPush("mylist", "1");
        stringRedisTemplate.opsForList().leftPush("mylist", "2");
    }
    @Test
    public void test2() {
        // 保存对象
        Account account = accountMapper.getAccountByMobile("1111");
        myRedisTemplate.opsForValue().set("account-01", account);
    }

}
