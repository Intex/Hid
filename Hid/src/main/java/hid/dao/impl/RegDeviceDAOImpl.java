package hid.dao.impl;

import hid.dao.RegDeviceDAO;
import hid.entity.groovy.RegDevice;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class RegDeviceDAOImpl extends AbstractDAOImpl<RegDevice> implements RegDeviceDAO{

	protected RegDeviceDAOImpl() {
		super(RegDevice.class);
	}

	@Override
	public List<RegDevice> findByDeviceId(long deviceId) {
		return findByProperty("deviceId", deviceId);
	}

	@Override
	public List<RegDevice> findByEndLicense(Date date) {
		return findByProperty("endLicenseDate", date);
	}
}
