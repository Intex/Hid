package com.intexsoft.sensor.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.intexsoft.sensor.dao.ConnectionDAO;
import com.intexsoft.sensor.entity.Connection;
import com.intexsoft.sensor.service.ConnectionService;

@Service
public class ConnectionServiceImpl extends AbstractServiceImpl<Connection> implements ConnectionService {
	
	@Autowired
	public ConnectionServiceImpl(ConnectionDAO connectionDAO) {
		super(connectionDAO);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Connection> findByCountry(String country) {
		return getDAO().findByCountry(country);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Connection> findByCity(String city) {
		return getDAO().findByCity(city);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Connection> findByDate(Date date) {
		return getDAO().findByDate(date);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Connection> findByDeviceId(long deviceId) {
		return getDAO().findByDeviceId(deviceId);
	}
	
	@Override
	public ConnectionDAO getDAO() {
		return (ConnectionDAO) super.getDAO();
	}

}
