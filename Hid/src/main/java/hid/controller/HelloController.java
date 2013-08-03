package hid.controller;

import hid.entity.groovy.Admin;
import hid.service.AdminService;

import javax.xml.ws.soap.Addressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(Model model) {
		model.addAttribute("message", "This is emty Spring + Hibernate project gooz");
		return "index";
	}
}