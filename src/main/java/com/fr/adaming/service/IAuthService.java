package com.fr.adaming.service;

import com.fr.adaming.entity.User;

public interface IAuthService {

	public User login(String email,String pwd);
	public String register(User user);
	
	
}
