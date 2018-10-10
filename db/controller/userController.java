package db.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import db.model.User;
import db.service.UserService;


@Controller
public class userController {

	UserService userService=new UserService();
	@RequestMapping(path = {"/", "/#"}, method = RequestMethod.GET)
    public String index() {
		//System.out.println("bb");
        return "index";
    }
	@RequestMapping(path = {"/user/login"}, method = RequestMethod.POST)
	@ResponseBody
	public Boolean getInfo(@RequestBody User user) {
		System.out.println("aaaa");
		return userService.checkUser(user.getName(), user.getPassword());
	}
	@RequestMapping(path = {"/user/logup"}, method = RequestMethod.POST)
	@ResponseBody
	public Boolean loadInfo(@RequestBody User user) {
		return userService.insertUser(user.getName(), user.getPassword());
	}
	
}
