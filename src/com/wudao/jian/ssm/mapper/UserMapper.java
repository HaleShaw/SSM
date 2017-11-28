package com.wudao.jian.ssm.mapper;

import java.io.Serializable;
import java.util.List;

import com.wudao.jian.ssm.domain.User;

public interface UserMapper {
	User get(Serializable id);
	List<User> getAll();
}
