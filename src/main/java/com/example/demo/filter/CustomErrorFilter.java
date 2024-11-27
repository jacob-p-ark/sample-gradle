package com.example.demo.filter;

import com.example.demo.config.WebConfig;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomErrorFilter extends ErrorPageFilter {
    private static final Logger log = LoggerFactory.getLogger(CustomErrorFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 초기화 로직 (필요 시)
        log.info("CustomErrorFilter  init");
        log.info("CustomErrorFilter  init");
        log.info("CustomErrorFilter  init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            log.info("doFilter  init");
            log.info("doFilter  init");
            log.info("doFilter  init");
            chain.doFilter(request, response); // 다음 필터로 요청 전달

        } catch (Exception ex) {
            // 에러 발생 시 처리 로직
            log.info("Exception  init");
            log.info("Exception  init");
            log.info("Exception  init");
            httpResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write("{\"error\":\"Custom error occurred!\"}");

            throw new IOException("ServletOutputStream is already closed!");
        }
    }

    @Override
    public void destroy() {
        // 필터 종료 시 로직 (필요 시)
        log.info("destroy  init");
        log.info("destroy  init");
        log.info("destroy  init");
    }
}
