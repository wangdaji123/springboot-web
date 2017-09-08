package com.wangdj.controller.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wangdj.controller.config.ApiVersion;
import com.wangdj.entity.User;
import com.wangdj.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
//通过这里配置使下面的映射都在/userRestSwagger/下
@Api(value="用户controller",description="用户管理",tags={"用户管理接口"})
@RestController
@RequestMapping(value="/userRestSwagger/")
public class UserRestSwaggerController {
	@Autowired
	private UserService userSerivce;
	// 创建线程安全的Map 
	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>()); 
	@ApiVersion
	@ApiOperation(value="获取用户列表", notes="")
	@GetMapping(value="getUserList")
	public List<User> getUserList() {
		List<User> r = new ArrayList<User>(users.values());
		return r;
	}
	@ApiVersion
	@ApiOperation(value="创建用户", notes="根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@PostMapping(value="postUser")
	public String postUser(@RequestBody User user) {
		users.put(user.getId(), user);
		return "success";
	}
	@ApiVersion
	@ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	@GetMapping(value="getUser/{id}")
	public User getUser(@PathVariable Long id) {
		return users.get(id);
	}

	@ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
	@ApiVersion
	@PutMapping(value="putUser/{id}")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
		@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	})
	public String putUser(@PathVariable Long id, @RequestBody User user) {
		User u = users.get(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		users.put(id, u);
		return "success";
	}
	@ApiVersion
	@ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	@DeleteMapping(value="deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		users.remove(id);
		return "success";
	}
	@ApiVersion
	@ApiOperation(value="新增用户", notes="根据userName,age创建用户")
	@PostMapping(value="createUser")
	public String createUser(@ApiParam(value = "用户名") @RequestParam(value = "userName", required = false) String userName,
							 @ApiParam(value = "年龄") @RequestParam(value = "age", required = false) int age) {
		userSerivce.create(userName, age);
		return "success";
	}
}
