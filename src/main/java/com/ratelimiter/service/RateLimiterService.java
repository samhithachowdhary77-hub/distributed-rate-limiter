package com.ratelimiter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimiterService {

    private static final int LIMIT = 10;
    private static final Duration WINDOW = Duration.ofMinutes(1);

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean isAllowed(String userId) {

        String key = "rate_limit:" + userId;

        Long requests = redisTemplate.opsForValue().increment(key);

        if (requests == 1) {
            redisTemplate.expire(key, WINDOW);
        }

        return requests <= LIMIT;
    }
}