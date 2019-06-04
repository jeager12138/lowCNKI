package com.redemption.hair.lowCNKI.utils;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

@Service
public class JedisAdapter implements InitializingBean {
    private JedisPool pool;
    @Override
    public void afterPropertiesSet() throws Exception {
        pool = new JedisPool();
    }


    public void addSearchHistory(String userId, String title_paper) {
        Jedis jedis = pool.getResource();
        jedis.lpush("SEARCHHISTORY:" + userId, title_paper);
    }

    public List<String> getSearchHistory(String userId) {
        List<String> list = new ArrayList<>();
        String key = "SEARCHHISTORY:" + userId;
        Jedis jedis = pool.getResource();
        if (!jedis.exists(key)) {
            return list;
        }
        list = jedis.lrange(key, 0, jedis.llen(key)>10?10:jedis.llen(key));
        return list;
    }


}
