package com.intexsoft.service;

import java.util.List;

import com.intexsoft.entity.Device;

public interface DeviceService extends AbstractService<Device> {
	List<Device> findByVendorId(int vendorId);
	List<Device> findByProductId(int productId);
}
