package com.wangdj.controller.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangdj.entity.User;

import io.swagger.annotations.Api;

//通过这里配置使下面的映射都在/userRest下
@Api(value="用户controller1",description="用户管理1",tags={"用户管理接口1"})
@RestController
@RequestMapping(value="/userRest/")
public class UserRestController {
	// 创建线程安全的Map 
	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>()); 

	// 处理"/users/"的GET请求，用来获取用户列表 
	// 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递 
	@GetMapping(value="getUserList1/") 
	public List<User> getUserList1() { 
		List<User> r = new ArrayList<User>(users.values()); 
		return r; 
	} 
	// 处理"/users/"的POST请求，用来创建User 
	// 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数 
	@PostMapping(value="postUser1/") 
	public String postUser1(@ModelAttribute User user) {  
		users.put(user.getId(), user); 
		return "success"; 
	} 
	// 处理"/users/{id}"的GET请求，用来获取url中id值的User信息 
	// url中的id可通过@PathVariable绑定到函数的参数中 
	@GetMapping(value="getUser1/{id}") 
	public User getUser1(@PathVariable String id) { 
		return users.get(id); 
	} 
	// 处理"/users/{id}"的PUT请求，用来更新User信息 
	@PutMapping(value="putUser1/{id}") 
	public String putUser1(@PathVariable String id, @ModelAttribute User user) { 
		User u = users.get(id); 
		u.setName(user.getName()); 
		u.setAge(user.getAge()); 
		users.put(Long.valueOf(id), u); 
		return "success"; 
	} 
	// 处理"/users/{id}"的DELETE请求，用来删除User 
	@DeleteMapping(value="deleteUser1/{id}") 
	public String deleteUser1(@PathVariable String id) { 
		users.remove(id); 
		return "success"; 
	} 

}
