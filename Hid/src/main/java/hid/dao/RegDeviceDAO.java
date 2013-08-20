package hid.dao;

import java.util.Date;
import java.util.List;

import hid.entity.java.RegDevice;

public interface RegDeviceDAO extends AbstractDAO<RegDevice> {

	List<RegDevice> findByDeviceId(long deviceId);

	List<RegDevice> findByEndLicense(Date date);

}
