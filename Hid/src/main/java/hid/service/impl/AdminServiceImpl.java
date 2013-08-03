package hid.service.impl;

import hid.dao.AdminDAO;
import hid.entity.groovy.Admin;
import hid.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
