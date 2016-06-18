package com.atguigu.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entities.User;
import com.atguigu.crm.mapper.UserMapper;
import com.atguigu.crm.service.UserService;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserMapper userMapper;
	
	public User login(User user)
	{
		return userMapper.getUserByName(user);
	}
}
