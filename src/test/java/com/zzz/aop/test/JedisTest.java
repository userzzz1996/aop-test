package com.zzz.aop.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

import javax.naming.Name;

/**
 * @Title: JedisTest
 * @Package: com.zzz.aop.test
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/06/22 0022 19:04
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class JedisTest {

    @Test
   public void test(){

        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("name","zhangsan");
        jedis.close();
        
    }
}
