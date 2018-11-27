package com.zxa.shortcut.controller.starter;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: ApplicationWeb
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/26 21:15
 */

@Configuration
@EnableEncryptableProperties
@ComponentScan(basePackages = {"com.zxa.shortcut.*", "com.zxa.shortcut.controller"})
@EnableAutoConfiguration
@MapperScan("com.zxa.shortcut.dao")
public class ApplicationWeb {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationWeb.class, args);
	}

}
