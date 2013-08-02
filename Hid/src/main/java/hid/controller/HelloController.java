package hid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(Model model) {
		model.addAttribute("message", "This is emty Spring + Hibernate project dunyasha like beer!");
		return "index";
	}
}