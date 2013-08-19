package com.intexsoft.dao;

import java.util.List;

import com.intexsoft.entity.Device;

public interface DeviceDAO extends AbstractDAO<Device>{

	List<Device> findByVendorId(int vendorId);
	List<Device> findByProductId(int productId);
}
