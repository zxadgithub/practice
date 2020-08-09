package com.zxa.ioc.bean;

/**
 * @Classname BeanDefinition
 * @Date 2020/8/7 8:48 上午
 * @Created by zhangxinan
 */
public class BeanDefinition {
	private String name;

	private Object instance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getInstance() {
		return instance;
	}

	public void setInstance(Object instance) {
		this.instance = instance;
	}
}
