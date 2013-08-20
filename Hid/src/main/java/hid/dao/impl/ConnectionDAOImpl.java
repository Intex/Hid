package hid.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import hid.dao.ConnectionDAO;
import hid.entity.java.Connection;
@Repository
public class ConnectionDAOImpl extends AbstractDAOImpl<Connection> implements ConnectionDAO {	

	protected ConnectionDAOImpl() {
		super(Connection.class);
	}

	@Override
	public List<Connection> findByCountry(String country) {
		return findByProperty("country", country);
	}

	@Override
	public List<Connection> findByCity(String city) {
		return findByProperty("city", city);
	}

	@Override
	public List<Connection> findByDate(Date date) {
		return findByProperty("date", date);
	}

	@Override
	public List<Connection> findByDeviceId(long deviceId) {
		return findByProperty("deviceId", deviceId);
	}
}
