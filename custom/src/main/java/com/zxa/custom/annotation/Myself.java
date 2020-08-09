package com.zxa.custom.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname Myself
 * @Description TODO
 * @Date 2020/3/18 12:01 下午
 * @Created by zhangxinan
 */

@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.CLASS)
public @interface Myself {
}
