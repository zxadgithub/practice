package com.zxa.shortcut.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import static org.springframework.web.bind.annotation.CrossOrigin.DEFAULT_ALLOWED_HEADERS;
import static org.springframework.web.bind.annotation.CrossOrigin.DEFAULT_ORIGINS;
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 可添加多个
		registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**");

	}
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins(DEFAULT_ORIGINS)
				.allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
				.allowedHeaders(DEFAULT_ALLOWED_HEADERS)
				.allowCredentials(true)
				.maxAge(3600);
	}


}
