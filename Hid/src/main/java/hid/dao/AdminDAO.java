package hid.dao;

import hid.entity.groovy.Admin;

public interface AdminDAO extends AbstractDAO<Admin> {
	Admin findByLogin(String login);
}
