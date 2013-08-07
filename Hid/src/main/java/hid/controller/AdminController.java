package hid.controller;

import hid.entity.groovy.Admin;
import hid.service.AdminService;
import hid.service.PasswordHasher;
import hid.validation.AddAdminFormValidationGroup;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView logInPage() {
		return new ModelAndView("login", "admin", emptyAdmin);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView logIn(@Valid Admin admin, BindingResult result, HttpSession session) {
		if (!result.hasErrors()) {
			Admin dbAdmin = adminService.findByLogin(admin.getLogin());
			System.out.println(dbAdmin.getLogin());
			if (dbAdmin != null && passwordHasher.isPasswordCorrect(admin.getPassword(), dbAdmin.getHashPassword(), dbAdmin.getSalt())) {
				adminService.logIn(session, dbAdmin);
				return addAdminPage(session);
			}
		}
		return new ModelAndView("login", "admin", admin);
	}

	@RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
	public ModelAndView addAdminPage(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model.addObject("admin", emptyAdmin);
		/* if (!adminService.isLogIn(session)) {
			model.setViewName("redirect:login");
			return model;
		} */
		model.addObject("adminList", adminService.getAll());
		return model;
	}

	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public ModelAndView addAdmin(@Validated({AddAdminFormValidationGroup.class}) Admin admin, BindingResult result, HttpSession session) {
		ModelAndView model = new ModelAndView("addAdmin");
		if (result.hasErrors()) {
			model.addObject("admin", admin);
		} else {
			System.out.println(admin.getLogin());
			admin.setHashPassword(passwordHasher.hashPassword(admin.getPassword()));
			admin.setSalt(passwordHasher.getSalt());
			adminService.saveOrUpdate(admin);
			model.addObject("admin", emptyAdmin);
		}
		model.addObject("adminList", adminService.getAll());
		return model;
	}

}
