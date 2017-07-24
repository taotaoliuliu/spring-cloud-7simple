package cloud.simple.service.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.simple.service.domain.UserService;
import cloud.simple.service.model.User;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> readUserInfo(){
		List<User> ls=userService.searchAll();		
		System.out.println("ccccccccc");
		return ls;
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public void adduser( @RequestBody User user,HttpServletRequest request,String username){
		
		
		System.out.println(username+"ccccccccc");
		
		
		userService.adduser(user);
	}
	
	
	@RequestMapping(value="/adduser2",method=RequestMethod.POST)
	public void adduser2(HttpServletRequest request,String username){
		
		User aa =new User();
		
		aa.setUsername(username);
		
		aa.setId(1);
		userService.adduser(aa);
	}
	
}
