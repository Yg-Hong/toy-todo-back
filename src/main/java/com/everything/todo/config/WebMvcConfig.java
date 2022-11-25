package com.everything.todo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final long MAX_AGE_SECS = 3600;

    @Override
    /*addCorsMappings
    * 모든 경로(/**)에 대해 Origin이 http://localhost:3000인 경우,
     GET, POST, PUT, PATCH, DELETE 메서드를 허용
     또한 모든헤더와 인증에 관한 정보(Credential)도 허용한다.
     */
    public void addCorsMappings(CorsRegistry registry){
        //모든 경로에 대해
        registry.addMapping("/**")
                // Origin이 http:localhost:3000인 경우
                .allowedOrigins("http://localhost:3000")
                // GET, POST, PUT, PATCH, DELETE, OPTIONS 메서드 허용
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(MAX_AGE_SECS);
    }
}
