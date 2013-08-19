package com.intexsoft.dao;

import com.intexsoft.entity.Admin;

public interface AdminDAO extends AbstractDAO<Admin> {
	Admin findByLogin(String login);
}
