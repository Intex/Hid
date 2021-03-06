package com.intexsoft.sensor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intexsoft.sensor.dao.AdminDAO;
import com.intexsoft.sensor.entity.Admin;
import com.intexsoft.sensor.service.AdminService;

@Service
public class AdminServiceImpl extends AbstractServiceImpl<Admin> implements AdminService {

	@Autowired
	public AdminServiceImpl(AdminDAO adminDAO) {
		super(adminDAO);
	}

	@Override
	@Transactional
	public Admin findByLogin(String login) {
		return getDAO().findByLogin(login);
	}
	
	@Override
	public AdminDAO getDAO() {
		return (AdminDAO) super.getDAO();
	}

	/* @Override
	public boolean isLogIn(HttpSession session) {
		return session.getAttribute("id") != null && session.getAttribute("login") != null;
	}

	@Override
	public void logIn(HttpSession session, Admin admin) {
		session.setAttribute("login", admin.getLogin());
		session.setAttribute("id", admin.getId());
	}

	@Override
	public void logOut(HttpSession session) {
		session.removeAttribute("id");
		session.removeAttribute("login");		
	} */
}
