package com.wudao.jian.ssm.service;

import java.io.Serializable;
import java.util.List;

import com.wudao.jian.ssm.domain.User;

public interface IUserService {
	User get(Serializable id);
	List<User> getAll();
}
