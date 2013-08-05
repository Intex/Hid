package hid.controller;

import hid.service.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeviceListController {
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(value = "/allDevice", method = RequestMethod.GET)
	public ModelAndView getAllDevicesPage()
	{
		ModelAndView model=new ModelAndView("allDevice");
		model.addObject("deviceList", deviceService.getAll());
		return model;
	}

}
