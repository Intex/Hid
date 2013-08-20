package hid.dao;

import hid.entity.java.Admin;

public interface AdminDAO extends AbstractDAO<Admin> {
	Admin findByLogin(String login);
}
