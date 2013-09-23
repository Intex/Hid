package com.intexsoft.sensor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intexsoft.sensor.entity.Device;
import com.intexsoft.sensor.service.ConnectionService;
import com.intexsoft.sensor.service.DeviceService;

@Controller
public class DeviceController extends JsonBaseController {

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private ConnectionService connectionService;
	
	@RequestMapping(value = "devices", method = GET)
	public @ResponseBody JsonResponse getDeviceById(@RequestParam long id) {
		return new JsonResponse(deviceService.findById(id));
	}
	
	@RequestMapping(value = "devices/add", method = POST)
	public @ResponseBody JsonResponse addDevice(@Valid Device device) {
		deviceService.saveOrUpdate(device);
		return new JsonResponse(true);
	}
	
	@RequestMapping(value = "/test", method = GET)
	public @ResponseBody JsonResponse testResponse() {
		return new JsonResponse(true);
	}
}