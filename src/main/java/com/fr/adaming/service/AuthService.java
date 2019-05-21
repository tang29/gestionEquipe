package com.fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.dao.IUserDao;
import com.fr.adaming.entity.User;

@Service
@RequestMapping(path ="api/auth")
public class AuthService implements IAuthService {

	@Autowired 
	private IUserDao dao;

	@Override
	public User login(String email, String pwd) {
		// TODO Auto-generated method stub
		return  dao.findByEmailAndPwd(email, pwd);
	}

	@Override
	public String register(User user) {
		dao.save(user);
		return "Welcome";
		// TODO Auto-generated method stub
		
	}
}
