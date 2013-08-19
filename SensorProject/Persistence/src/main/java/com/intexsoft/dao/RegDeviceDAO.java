package com.intexsoft.dao;

import java.util.Date;
import java.util.List;

import com.intexsoft.entity.RegDevice;

public interface RegDeviceDAO extends AbstractDAO<RegDevice> {

	List<RegDevice> findByDeviceId(long deviceId);

	List<RegDevice> findByEndLicense(Date date);

}
