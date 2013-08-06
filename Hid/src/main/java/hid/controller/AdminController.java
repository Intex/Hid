package hid.controller;

import hid.entity.groovy.Admin;
import hid.service.AdminService;
import hid.service.PasswordHasher;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private PasswordHasher passwordHasher;
	
	private Admin emptyAdmin = new Admin();
	
	public ModelAndView logIn(Admin admin) {
		return new ModelAndView();
	}
	
	@RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
	public ModelAndView addAdminPage() {
		ModelAndView model = new ModelAndView("addAdmin");
		model.addObject("admin", emptyAdmin);
		model.addObject("adminList", adminService.getAll());
		return model;
	}
	
	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public ModelAndView addAdmin(@Valid Admin admin, BindingResult result) {
		ModelAndView model = new ModelAndView("addAdmin");		
		if (result.hasErrors()) {
			model.addObject("admin", admin);
		} else {			
			admin.setHashPassword(passwordHasher.hashPassword(admin.getPassword()));
			admin.setSalt(passwordHasher.getSalt());
			adminService.saveOrUpdate(admin);
			model.addObject("admin", emptyAdmin);
		}
		model.addObject("adminList", adminService.getAll());
		return model;
	}

}
