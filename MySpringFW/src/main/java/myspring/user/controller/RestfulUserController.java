package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RestController // controller + responseBody ( json 형태로 보여줌. )
@RequestMapping("/users")
public class RestfulUserController {
	@Autowired
	private UserService userService;

//	@RequestMapping(value="/",
//			                 method=RequestMethod.GET,produces = { "application/json"})
	@GetMapping
	public List<UserVO> getUserList() {
		List<UserVO> userList = userService.getUserList();
		return userList;
	}
	
//	@RequestMapping(value="/{id}",
//			                    method=RequestMethod.GET,produces = { "application/json"})
	@GetMapping("/{userId}")
	public UserVO getUser(@PathVariable("userId") String id) {
		UserVO user = userService.getUser(id);
		return user;
	}
		
//	@RequestMapping(value="",
//			                 method=RequestMethod.POST,
//			                 headers = {"Content-type=application/json"})
	@PostMapping("/")
	public Boolean insertUser(@RequestBody UserVO user) {
		if (user != null) {
			userService.insertUser(user);
			return Boolean.TRUE;
		} else {	
			return Boolean.FALSE;
		}
	}
	
//	@RequestMapping(value="/users",
//			                 method=RequestMethod.PUT,
//			                headers = {"Content-type=application/json"})
	@PutMapping("/")
	public Boolean updateUser(@RequestBody UserVO user) {
		if (user != null) {
			userService.updateUser(user);
			return Boolean.TRUE;
		} else {	
			return Boolean.FALSE;
		}
	}
	
//	@RequestMapping(value="/users/{id}",
//			         method=RequestMethod.DELETE)
	@DeleteMapping("/{userId}")
	public Boolean deleteUser(@PathVariable("userId") String id) {
		if (id != null) {
			userService.deleteUser(id);
			return Boolean.TRUE;
		} else {		
			return Boolean.FALSE;
		}
	}
		
}
