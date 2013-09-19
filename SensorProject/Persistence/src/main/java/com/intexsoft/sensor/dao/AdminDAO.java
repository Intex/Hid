package com.intexsoft.sensor.dao;

import com.intexsoft.sensor.entity.Admin;

public interface AdminDAO extends AbstractDAO<Admin> {
	Admin findByLogin(String login);
}
