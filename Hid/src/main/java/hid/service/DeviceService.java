package hid.service;

import java.util.List;

import hid.entity.java.Device;

public interface DeviceService extends AbstractService<Device> {
	List<Device> findByVendorId(int vendorId);
	List<Device> findByProductId(int productId);
}
