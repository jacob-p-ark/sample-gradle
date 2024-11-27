package com.example.demo;

import com.example.demo.filter.CustomErrorFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean<CustomErrorFilter> customErrorFilter() {
//		FilterRegistrationBean<CustomErrorFilter> registrationBean = new FilterRegistrationBean<>();
//		registrationBean.setFilter(new CustomErrorFilter());
//		registrationBean.addUrlPatterns("/*"); // 필터 적용 URL 패턴 설정
//		registrationBean.setOrder(1); // 필터 순서 지정
//		return registrationBean;
//	}

}
