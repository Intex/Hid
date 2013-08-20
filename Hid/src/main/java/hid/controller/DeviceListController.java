package hid.controller;

import hid.entity.java.Device;
import hid.service.DeviceService;
import hid.validation.AddAdminFormValidationGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeviceListController {
	@Autowired
	private DeviceService deviceService;

	private Device emptyDevice = new Device();

	@RequestMapping(value = "/allDevice", method = RequestMethod.GET)
	public ModelAndView getAllDevicesPage() {
		ModelAndView model = new ModelAndView("allDevice");
		model.addObject("device", emptyDevice);
		model.addObject("deviceList", deviceService.getAll());
		return model;
	}

	@RequestMapping(value = "/allDevice", method = RequestMethod.POST)
	public ModelAndView addDevice(@Validated Device device, BindingResult result) {
		ModelAndView model = new ModelAndView("allDevice");
		if(result.hasErrors()){
			model.addObject("device", device);
		}else{
			deviceService.saveOrUpdate(device);
			model.addObject("device", emptyDevice);
		}
		model.addObject("deviceList", deviceService.getAll());
		return model;
	}

}
