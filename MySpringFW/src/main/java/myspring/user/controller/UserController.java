package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	public UserController() {
		System.out.println(this.getClass().getName() + " 컨트롤러 기본 생성자 호출.");
	}
	
	/*
	 *  modelAndView( viewName : String, ModelName : String, modelObject : Object )
	 *  
	 *  viewName : "userDetail" ( 즉, 열어야할 jsp 파일) 
	 *  modelName : "user" // 모델의 이름을 지어주는 것.
	 *  mdoelObject : userVO
	 *  
	 *  	ex) user의 세부정보    GetMapping( "/getUser.do" )
	 *  		- new ModelAndView( 열어야할 JSP 파일, 모델의 이름, 전달해야할 데이터 객체 ) 
	 * */
	@RequestMapping("/getUser.do")
	// 변수명과 파라미터가 동일하다면 따로 value값을 적어줄 필요는 없지만, 동일하지 않다면 value를 꼭 적어줘야한다.
	public ModelAndView getUser(@RequestParam(value = "userId")String userId) {
		UserVO user = userService.getUser(userId);
		
		//ModelAndView
		return new ModelAndView("userDetail", "user", user);
	}
	
	@RequestMapping("/getUserList.do")
	public String getUserList(Model model) {
		List<UserVO> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		
		return "userList";
	}

}
