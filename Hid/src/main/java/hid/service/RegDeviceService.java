package hid.service;

import java.util.Date;
import java.util.List;

import hid.entity.java.RegDevice;

public interface RegDeviceService extends AbstractService<RegDevice> {

	List<RegDevice> findByDeviceId(long deviceId);

	List<RegDevice> findByEndLicense(Date date);

}
