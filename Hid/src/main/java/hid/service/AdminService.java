package hid.service;

import javax.servlet.http.HttpSession;

import hid.entity.groovy.Admin;

public interface AdminService extends AbstractService<Admin>{
	Admin findByLogin(String login);
	boolean isLogIn(HttpSession session);
	void logIn(HttpSession session, Admin admin);
	void logOut(HttpSession session);
}
