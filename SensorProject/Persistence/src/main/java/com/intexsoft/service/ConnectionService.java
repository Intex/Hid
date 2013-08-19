package com.intexsoft.service;

import java.util.Date;
import java.util.List;

import com.intexsoft.entity.Connection;

public interface ConnectionService extends AbstractService<Connection> {

	List<Connection> findByCountry(String country);

	List<Connection> findByCity(String city);

	List<Connection> findByDate(Date date);

	List<Connection> findByDeviceId(long deviceId);

}
