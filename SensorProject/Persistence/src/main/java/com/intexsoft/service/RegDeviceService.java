package com.intexsoft.service;

import java.util.Date;
import java.util.List;

import com.intexsoft.entity.RegDevice;

public interface RegDeviceService extends AbstractService<RegDevice> {

	List<RegDevice> findByDeviceId(long deviceId);

	List<RegDevice> findByEndLicense(Date date);

}
