package com.nav.qanda.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nav.qanda.authentication.dao.UserDao;
import com.nav.qanda.authentication.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao uDao;
	
	@Override
	public User login(User u) {
		return uDao.login(u);
	}
}
