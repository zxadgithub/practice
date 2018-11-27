package com.zxa.shortcut.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName: ConfigTest
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/27 11:00
 */
public class ConfigTest {
	@Value("${spring.datasource.password}")
	private String password;
}
