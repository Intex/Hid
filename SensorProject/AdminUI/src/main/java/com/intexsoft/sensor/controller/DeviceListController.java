package com.intexsoft.sensor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.intexsoft.sensor.service.ConnectionService;
import com.intexsoft.sensor.service.DeviceService;

@Controller
public class DeviceListController {

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private ConnectionService connectionService;
}