package com.atguigu.crm.mapper;

import org.springframework.stereotype.Repository;

import com.atguigu.crm.entities.User;

@Repository
public interface UserMapper
{
	public User getUserByName(User user);
}
