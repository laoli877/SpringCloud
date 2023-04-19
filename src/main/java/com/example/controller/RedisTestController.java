package com.example.controller;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Resource
    RedisTemplate redisTemplate;


    @RequestMapping("/setRedis")
    public String setRedis(){
        // 字符串
        redisTemplate.boundValueOps("string").set("String字符串");
        System.out.println("字符串string:"+ redisTemplate.opsForValue().get("string"));

        // hash
        redisTemplate.boundHashOps("hash").put("name", "hash1");
        redisTemplate.boundHashOps("hash").put("age", "16");
        // 获取所有域
        Set set = redisTemplate.boundHashOps("hash").keys();
        System.out.println("hash散列所有域:"+set);
        // 获取所有值
        List hashlist = redisTemplate.boundHashOps("hash").values();
        System.out.println("hash散列的所有域的值：" + hashlist);
        Object o = redisTemplate.boundHashOps("hash").get("name");
        System.out.println("hash散列通过键获取值:"+String.valueOf(o));

        // set集合
        redisTemplate.boundSetOps("set").add("a", "b", "c");
        Set members = redisTemplate.boundSetOps("set").members();
        System.out.println("set集合中的所有元素："+members);
        Long remove = redisTemplate.boundSetOps("set").remove("a");
        System.out.println("移除集合："+remove);
        System.out.println("set集合中的所有元素："+redisTemplate.boundSetOps("set").members());

        // list列表
        redisTemplate.boundListOps("list").leftPush("a");
        redisTemplate.boundListOps("list").leftPush("b");
        redisTemplate.boundListOps("list").leftPush("c");
        redisTemplate.boundListOps("list").trim(-1,0); // 清空list
        List lists = redisTemplate.boundListOps("list").range(0, -1); // 所有元素
//        // 获取所有元素
        System.out.println("list列表中的所有元素:"+ lists);

        // sorted set
        redisTemplate.boundZSetOps("sort_key").add("a",90);
        redisTemplate.boundZSetOps("sort_key").add("b",80);
        Set sortKey = redisTemplate.boundZSetOps("sort_key").range(0, -1);  // 所有元素
        System.out.println("sorted set有序集合中的所有元素："+sortKey);

        return null;



    }
}
