package com.wangdj.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
@Api(value="HelloController测试",description="用户管理1",tags={"用户管理接口1"})
@Controller
@RequestMapping("hello")
public class HelloController {
	@GetMapping("/index")
	public String index(ModelMap map){
		// 加入一个属性，用来在模板中读取
		map.addAttribute("host", "http://blog.didispace.com");
		 // return模板文件的名称，对应src/main/resources/templates/thymeleaf1.html
		return "index";
	}
}
