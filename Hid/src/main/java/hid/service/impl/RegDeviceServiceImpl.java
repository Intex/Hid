package hid.service.impl;

import hid.dao.RegDeviceDAO;
import hid.entity.java.RegDevice;
import hid.service.RegDeviceService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class RegDeviceServiceImpl extends AbstractServiceImpl<RegDevice> implements RegDeviceService {
	
	@Autowired
	public RegDeviceServiceImpl(RegDeviceDAO regDeviceDAO) {
		super(regDeviceDAO);
	}

	@Override
	@Transactional
	public List<RegDevice> findByDeviceId(long deviceId) {
		return getDAO().findByDeviceId(deviceId);
	}

	@Override
	@Transactional
	public List<RegDevice> findByEndLicense(Date date) {
		return getDAO().findByEndLicense(date);
	}
	
	@Override
	public RegDeviceDAO getDAO() {
		return (RegDeviceDAO) super.getDAO();
	}
}
