package com.ratelimiter.controller;

import com.ratelimiter.service.RateLimiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RateLimiterController {

    @Autowired
    private RateLimiterService rateLimiterService;

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint(@RequestParam String userId) {

        boolean allowed = rateLimiterService.isAllowed(userId);

        if (!allowed) {
            return ResponseEntity.status(429).body("Too Many Requests");
        }

        return ResponseEntity.ok("Request successful");
    }
}