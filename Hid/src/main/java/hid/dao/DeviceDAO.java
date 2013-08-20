package hid.dao;

import java.util.List;

import hid.entity.java.Device;

public interface DeviceDAO extends AbstractDAO<Device>{

	List<Device> findByVendorId(int vendorId);
	List<Device> findByProductId(int productId);
}
