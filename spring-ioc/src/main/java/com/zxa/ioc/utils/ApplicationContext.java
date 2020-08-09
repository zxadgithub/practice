package com.zxa.ioc.utils;

import com.zxa.ioc.bean.BeanDefinition;

import java.util.List;

/**
 * @Classname BeanInital
 * @Date 2020/8/7 8:46 上午
 * @Created by zhangxinan
 */
public interface ApplicationContext {

	<T> T  getBeanByName(String name, Class<T> c) ;

	<T> T  getBeanByName(Class<T> c) ;


}
