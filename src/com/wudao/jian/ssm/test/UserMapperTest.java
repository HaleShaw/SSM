package com.wudao.jian.ssm.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wudao.jian.ssm.domain.User;
import com.wudao.jian.ssm.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testGet() {
		System.out.println(userMapper);
		User user = userMapper.get(1L);
		System.out.println(user);
	}

	@Test
	public void testGetAll() {
	}

}
