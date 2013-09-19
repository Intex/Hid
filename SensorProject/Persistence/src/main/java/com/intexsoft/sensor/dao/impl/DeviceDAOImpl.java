package com.intexsoft.sensor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.intexsoft.sensor.dao.DeviceDAO;
import com.intexsoft.sensor.entity.Device;


@Repository
public class DeviceDAOImpl extends AbstractDAOImpl<Device> implements DeviceDAO {
	
	protected DeviceDAOImpl() {
		super(Device.class);
	}

	@Override
	public List<Device> findByVendorId(int vendorId) {
		return findByProperty("vendorId", vendorId);
	}

	@Override
	public List<Device> findByProductId(int productId) {
		return findByProperty("productId", productId);
	}

}
