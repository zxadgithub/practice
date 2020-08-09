package com.zxa.shortcut.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: MyConfiguration
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2019/1/27 21:07
 */
@Configuration
public class MyHandlerInterceptor implements HandlerInterceptor {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		//处理跨域问题
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				request.getHeader("Access-Control-Request-Headers"));
		logger.info("跨域请求" + request.getContextPath() + "返回值" + response.getHeader("Access-Control-Allow-Origin"));

		if(request.getMethod().equals(RequestMethod.OPTIONS.name())) {
			response.setStatus(HttpStatus.OK.value());
			return true;
		}

		return true;
	}
}

