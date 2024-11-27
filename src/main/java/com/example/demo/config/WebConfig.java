package com.example.demo.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final Logger log = LoggerFactory.getLogger(WebConfig.class);

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:8081") // 허용할 출처
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드
//                .allowedHeaders("*") // 허용할 헤더
//                .allowCredentials(true); // 쿠키 허용
//    }

//    //servlet mode
//    @Bean
//    public ServletRegistrationBean<PluginFreeServlet> getServletRegistrationBean()
//    {
//        ServletRegistrationBean<PluginFreeServlet> registrationBean = new ServletRegistrationBean<PluginFreeServlet>(new PluginFreeServlet());
//        registrationBean.addUrlMappings("/nppfs.servlet.do");	//add url mapping
//        registrationBean.addInitParameter("PropertiesPath",
//                "/app/imeco/webapps/x-force/WEB-INF/classes/nprotect.properties");
//        registrationBean.addInitParameter("ResponseEncoding", "UTF-8");	//add init-param
//        // CORS 요청 시 허용 Methods를 지정합니다.
//        registrationBean.addInitParameter("Access-Control-Allow-Origin", "*");
//        registrationBean.addInitParameter("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,UPDATE,OPTIONS");
//        // CORS 요청 시 허용 Headers를 지정합니다.
//        registrationBean.addInitParameter("Access-Control-Allow-Headers","Authorization, AuthorizationKey, X-Requested-With, X-HTTP-Method-Override, Content-Type, Accept");
//        // CORS 요청 시 Request의 결과가 캐시에 얼마나 남아있을지를 지정합니다.
//        registrationBean.addInitParameter("Access-Control-Max-Age", "1728000");
//        registrationBean.setLoadOnStartup(1);
//
//        return registrationBean;
//    }

    public class TestServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse response)throws ServletException, IOException {

            try {
                response.setContentType("application/json");
                response.getWriter().println("<h1>Hello, Servlet!</h1>");
                log.info("TestServlet get");
                log.info("TestServlet get");
                log.info("TestServlet get");

                // 응답 스트림에 데이터를 씁니다.
                response.getOutputStream().write("First Response".getBytes());

                // 응답 스트림을 명시적으로 닫습니다.
                response.getOutputStream().close();

                // 닫힌 스트림에 다시 쓰려고 시도하여 예외 발생
                response.getOutputStream().write("This will cause an exception".getBytes());

                if(true) throw new IOException("ServletOutputStream is already closed!");
            } catch (IOException e ) {
                e.printStackTrace();
            }
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("application/json");
            log.info("TestServlet post");
            log.info("TestServlet post");
            log.info("TestServlet post");
        }
    }

    @Bean
    public ServletRegistrationBean<TestServlet> getServletRegistrationBean(){
        ServletRegistrationBean<TestServlet> servletBean
                = new ServletRegistrationBean<>(
                        new TestServlet(), "/api/servlets/vkeypad.do");

        //add init-param
//        servletBean.addInitParameter("Method", "POST");
//        servletBean.addInitParameter("Content-Type", "application/json");

//        servletBean.addInitParameter("Access-Control-Allow-Origin", "*");
//        servletBean.addInitParameter("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,UPDATE,OPTIONS");
//        servletBean.addInitParameter("Access-Control-Allow-Headers","Authorization, AuthorizationKey, X-Requested-With, X-HTTP-Method-Override, Content-Type, Accept");
//        servletBean.addInitParameter("Access-Control-Max-Age", "1728000");
        servletBean.setLoadOnStartup(1);

        log.info("/api/servlets/vkeypad.do");
        log.info("/api/servlets/vkeypad.do");
        log.info("/api/servlets/vkeypad.do");

        return servletBean;
    }
}
