package hid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/tiles", method = RequestMethod.GET)
public class TilesController {
	
	@RequestMapping("")
	public String linkAction() {
		return "main";
	}
	
	@RequestMapping("{page}")
	public String linkAction(@PathVariable String page) {
		return page;
	}
}
