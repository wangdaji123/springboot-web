package com.wangdj.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 项目启动入口
 * @author daji.wang
 *
 */
@SpringBootApplication(scanBasePackages = {"com.wangdj"}, exclude = {})
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}
}
