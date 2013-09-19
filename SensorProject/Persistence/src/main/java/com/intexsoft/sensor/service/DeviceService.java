package com.intexsoft.sensor.service;

import java.util.List;

import com.intexsoft.sensor.entity.Connection;
import com.intexsoft.sensor.entity.Device;
import com.intexsoft.sensor.entity.RegDevice;

public interface DeviceService extends AbstractService<Device> {
	List<Device> findByVendorId(int vendorId);
	List<Device> findByProductId(int productId);
	void addConnection(Connection connection);
	void addRegDevice(RegDevice regDevice);
}
