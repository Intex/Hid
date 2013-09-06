package hid.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import hid.entity.java.Connection;
import hid.entity.java.Device;
import hid.service.ConnectionService;
import hid.service.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@Transactional(propagation = Propagation.REQUIRED)
	public @ResponseBody Set<Connection> getConnections(@PathVariable long deviceId) {
		//ModelAndView modelAndView = new ModelAndView("connections");		
		Device device = deviceService.findById(deviceId);
		System.out.println(device);
		Set<Connection> connectionList = device.getConnections();
		return connectionList;
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

	@RequestMapping(value = "/addConnectionDevice", method = RequestMethod.GET)
	public String addConnetcion(Connection connection) {
		connectionService.saveOrUpdate(connection);
		return "redirect:allDevice";
	}
	
	@RequestMapping(value = "/deleteDevice", method = RequestMethod.GET)
	public String deleteDevice(@RequestParam long id) {
		deviceService.delete(id);
		return "redirect:allDevice";
	}

	@RequestMapping(value = "/addConnection", method = RequestMethod.GET)
	public ModelAndView getAllConnectionPage() {
		ModelAndView model = new ModelAndView("addConnection");
		model.addObject("device", deviceService.findById(idConnectionDevice));
		model.addObject("connection", emptyConnection);
//		model.addObject("ConnectionList",
//				connectionService.findByDeviceId(idConnectionDevice));
		return model;
	}

	@RequestMapping(value = "addConnection", method = RequestMethod.POST)
	public ModelAndView addConnection(@Validated Device device, Connection connection,
			BindingResult result) {
		ModelAndView model = new ModelAndView("addConnection");
		List<Connection> outputConnection = new ArrayList<Connection>();
		if (result.hasErrors()) {
			model.addObject("connection", connection);
		} else {
			device = deviceService.findById(idConnectionDevice);
			deviceService.saveOrUpdate(device);
			connection.setDevice(device);
			connectionService.saveOrUpdate(connection);
			model.addObject("device", deviceService.findById(idConnectionDevice));
			model.addObject("connection", emptyConnection);
			List<Connection> con = connectionService.getAll();
			
			for(Connection conect : con){
			    Device div = conect.getDevice();
			    if(div.getId()==idConnectionDevice){
			    	outputConnection.add(conect);
			    }
			}
		}
		model.addObject("connectionList",outputConnection);
		return model;
	}
}
