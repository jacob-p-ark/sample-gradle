package com.example.demo.filter;

import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomErrorPageFilter extends ErrorPageFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try {
            // 기존 ErrorPageFilter 로직 수행
            super.doFilterInternal(request, response, chain);
        } catch (Exception ex) {
            // 에러 로깅 및 커스터마이즈된 응답 처리
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"An unexpected error occurred.\"}");
        }
    }

    @Override
    public void destroy() {
        // 리소스 정리
        super.destroy();
    }
}
