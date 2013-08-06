package hid.controller;

import hid.service.AdminService;

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
		model.addAttribute("message", "hello");
		return "index";
	}
}