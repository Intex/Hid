package hid.service.impl;

import hid.dao.ConnectionDAO;
import hid.entity.groovy.Connection;
import hid.service.ConnectionService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConnectionServiceImpl extends AbstractServiceImpl<Connection> implements ConnectionService{
	
	@Autowired
	public ConnectionServiceImpl(ConnectionDAO connectionDAO) {
		super(connectionDAO);
	}

	@Override
	@Transactional
	public List<Connection> findByCountry(String country) {
		return getDAO().findByCountry(country);
	}

	@Override
	@Transactional
	public List<Connection> findByCity(String city) {
		return getDAO().findByCity(city);
	}

	@Override
	@Transactional
	public List<Connection> findByDate(Date date) {
		return getDAO().findByDate(date);
	}

	@Override
	@Transactional
	public List<Connection> findByDeviceId(long deviceId) {
		return getDAO().findByDeviceId(deviceId);
	}
	
	@Override
	public ConnectionDAO getDAO() {
		return (ConnectionDAO) super.getDAO();
	}

}
