package org.service.booking.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/api/test")
    public Map<String, Object> test() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "서버가 정상적으로 실행 중입니다!");
        response.put("status", "success");
        response.put("timestamp", System.currentTimeMillis());
        return response;
    }
} 