package hid.controller;

import hid.entity.java.Connection;
import hid.entity.java.Device;
import hid.service.ConnectionService;
import hid.service.DeviceService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeviceListController {
	@Autowired
	private DeviceService deviceService;

	@Autowired
	private ConnectionService connectionService;

	public long idConnectionDevice;

	private Connection emptyConnection = new Connection();
	private Device emptyDevice = new Device();

	@RequestMapping(value = "/allDevice", method = RequestMethod.GET)
	public ModelAndView getAllDevicesPage() {
		ModelAndView model = new ModelAndView("allDevice");
		model.addObject("device", emptyDevice);
		model.addObject("deviceList", deviceService.getAll());
		return model;
	}

	@RequestMapping(value = "/{deviceId}/connections", method = RequestMethod.GET)
	public ModelAndView getConnections(@PathVariable long deviceId) {
		ModelAndView modelAndView = new ModelAndView("connections");		
		Device device = deviceService.findById(deviceId);
		Set<Connection> connectionList = device.getConnections();
		List<Connection> connectionAll = connectionService.getAll();
		modelAndView.addObject("connection", emptyConnection);
		modelAndView.addObject("connectionAll", connectionAll);
		modelAndView.addObject("connectionList", connectionList);
		modelAndView.addObject("deviceId", deviceId);
		return modelAndView;
	}

	@RequestMapping(value = "/allDevice", method = RequestMethod.POST)
	public ModelAndView addDevice(@Validated Device device, BindingResult result) {
		ModelAndView model = new ModelAndView("allDevice");
		if (result.hasErrors()) {
			model.addObject("device", device);
		} else {
			deviceService.saveOrUpdate(device);
			model.addObject("device", emptyDevice);
		}
		model.addObject("deviceList", deviceService.getAll());
		return model;
	}
	
	@RequestMapping(value = "/deleteDevice", method = RequestMethod.GET)
	public String deleteDevice(@RequestParam long id) {
		deviceService.delete(id);
		return "redirect:allDevice";
	}

	@RequestMapping(value = "/{deviceId}/connections/add", method = RequestMethod.POST)
	public String addConnection(@PathVariable long deviceId, Connection connection) {
		Device device = new Device(); // it's
		device.setId(deviceId); // very 
		connection.setDevice(device); // bad =(
		deviceService.addConnection(connection);
		return "redirect:" + "/" + deviceId + "/" + "connections/";
	}
}
