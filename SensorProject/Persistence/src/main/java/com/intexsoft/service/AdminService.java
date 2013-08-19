package com.intexsoft.service;

import com.intexsoft.entity.Admin;


public interface AdminService extends AbstractService<Admin>{
	Admin findByLogin(String login);
	//boolean isLogIn(HttpSession session);
	//void logIn(HttpSession session, Admin admin);
	//void logOut(HttpSession session);
}
