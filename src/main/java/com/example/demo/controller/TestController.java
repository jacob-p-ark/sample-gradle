package com.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/error")
    public String throwError() {
        throw new RuntimeException("This is a test error!");
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/trigger-error")
    public void triggerServletOutputStreamClosedError(HttpServletResponse response) throws IOException {

            // 응답 스트림에 데이터를 씁니다.
            response.getOutputStream().write("First Response".getBytes());

            // 응답 스트림을 명시적으로 닫습니다.
            response.getOutputStream().close();

            // 닫힌 스트림에 다시 쓰려고 시도하여 예외 발생
            response.getOutputStream().write("This will cause an exception".getBytes());
    }
}
