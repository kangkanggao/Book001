package com.highlion.service.impl;

import com.highlion.dao.UserDao;
import com.highlion.dao.impl.UserDaoimpl;
import com.highlion.domain.User;
import com.highlion.service.UserService;

public class UserServiceimpl implements UserService {
	UserDao userdao=new UserDaoimpl();
	@Override
	public Boolean login(User user) {
		// TODO Auto-generated method stub
		
		return userdao.login(user);
	}

}
