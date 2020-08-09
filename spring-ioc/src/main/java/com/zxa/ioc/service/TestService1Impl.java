package com.zxa.ioc.service;

import com.zxa.ioc.annotation.Component;

/**
 * @Classname TestService1Impl
 * @Date 2020/8/9 6:51 下午
 * @Created by zhangxinan
 */
@Component
public class TestService1Impl implements TestService1 {
	@Override
	public void test1() {
		System.out.println("====== test 11()====");
	}
}
