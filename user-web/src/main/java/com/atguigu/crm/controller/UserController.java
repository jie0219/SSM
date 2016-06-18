package com.atguigu.crm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.crm.entities.User;
import com.atguigu.crm.service.UserService;

@Controller
@RequestMapping("/crm")
public class UserController
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpServletRequest request,Map<String,Object> map)
	{
		User retValue = userService.login(user);
		
		if(null == retValue)
		{
			System.out.println("没有此人......");
			map.put("retValue", "This account is null");
			return "forward:/login.jsp";
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("retValue", retValue);
			return "success";
		}
	}
}
