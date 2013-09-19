package com.intexsoft.sensor.service;

import com.intexsoft.sensor.entity.Admin;


public interface AdminService extends AbstractService<Admin>{
	Admin findByLogin(String login);
	//boolean isLogIn(HttpSession session);
	//void logIn(HttpSession session, Admin admin);
	//void logOut(HttpSession session);
}
