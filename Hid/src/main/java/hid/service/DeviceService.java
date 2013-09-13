package hid.service;

import java.util.List;

import hid.entity.java.Connection;
import hid.entity.java.Device;
import hid.entity.java.RegDevice;

public interface DeviceService extends AbstractService<Device> {
	List<Device> findByVendorId(int vendorId);
	List<Device> findByProductId(int productId);
	void addConnection(Connection connection);
	void addRegDevice(RegDevice regDevice);
}
