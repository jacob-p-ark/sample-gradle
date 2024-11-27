package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/api/hello")
    public String hello() {
        return "Get, Swagger!";
    }

    @PostMapping("/api/hello")
    public Map<String, Object> Post(@RequestBody Map<String, Object> req) {
        log.info("req.toString(): {}", req.toString());
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("data", req);
        ret.put("message", "Hello World!");

        return ret;
    }
}
