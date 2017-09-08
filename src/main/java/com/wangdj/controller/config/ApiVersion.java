package com.wangdj.controller.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiVersion {
	// 版本号数组
	ApiVersionEnum[] value() default ApiVersionEnum.VERSION_10;
}
