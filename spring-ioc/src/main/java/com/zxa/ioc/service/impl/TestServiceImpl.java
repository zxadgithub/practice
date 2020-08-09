package com.zxa.ioc.service.impl;

import com.zxa.ioc.annotation.Autowired;
import com.zxa.ioc.annotation.Component;
import com.zxa.ioc.service.TestService;
import com.zxa.ioc.service.TestService1;

/**
 * @Classname TestServiceImpl
 * @Date 2020/8/9 6:33 下午
 * @Created by zhangxinan
 */
@Component(value = "testService")
public class TestServiceImpl implements TestService {

	@Autowired
	TestService1 testService1;

	@Override
	public void test() {
		System.out.println("==========test ========");
		testService1.test1();
	}
}
