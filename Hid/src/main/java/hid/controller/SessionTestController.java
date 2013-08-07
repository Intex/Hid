package hid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(method = RequestMethod.GET)
@SessionAttributes("count")
public class SessionTestController {
	
	@ModelAttribute("count")
	public int getCount() {
		return 0;
	}	
	
	@RequestMapping(value = "/session-test")
	public ModelAndView page(@ModelAttribute("count") int count) {
		count++;
		return new ModelAndView("session", "count", count);
	}
}
