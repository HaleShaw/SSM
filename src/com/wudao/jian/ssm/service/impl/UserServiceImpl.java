package com.wudao.jian.ssm.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wudao.jian.ssm.domain.User;
import com.wudao.jian.ssm.mapper.UserMapper;
import com.wudao.jian.ssm.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User get(Serializable id) {
		return userMapper.get(id);
	}

	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}

}
