package hid.service;

import hid.entity.groovy.Admin;

public interface AdminService extends AbstractService<Admin>{
	Admin findByLogin(String login);
}
