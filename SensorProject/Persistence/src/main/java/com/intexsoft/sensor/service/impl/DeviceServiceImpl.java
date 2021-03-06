package com.intexsoft.sensor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intexsoft.sensor.dao.DeviceDAO;
import com.intexsoft.sensor.entity.Connection;
import com.intexsoft.sensor.entity.Device;
import com.intexsoft.sensor.entity.RegDevice;
import com.intexsoft.sensor.service.DeviceService;

@Service
public class DeviceServiceImpl  extends AbstractServiceImpl<Device> implements DeviceService {
	
	@Autowired
	public DeviceServiceImpl(DeviceDAO deviceDAO) {
		super(deviceDAO);
	}

	@Override
	@Transactional
	public List<Device> findByVendorId(int vendorId) {
		return getDAO().findByVendorId(vendorId);
	}

	@Override
	@Transactional
	public void addConnection(Connection connection) {
		Device device = findById(connection.getDevice().getId());
		device.getConnections().add(connection);
		saveOrUpdate(device);
	}
	
	@Override
	@Transactional
	public void addRegDevice(RegDevice regDevice) {
		Device device = findById(regDevice.getDevice().getId());
		device.getRegDevices().add(regDevice);
		saveOrUpdate(device);
	}

	@Override
	@Transactional
	public List<Device> findByProductId(int productId) {
		return getDAO().findByProductId(productId);
	}
	
	@Override
	public DeviceDAO getDAO() {
		return (DeviceDAO) super.getDAO();
	}


}
