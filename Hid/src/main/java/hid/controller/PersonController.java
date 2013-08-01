package hid.controller;

import javax.validation.Valid;

import hid.entity.java.Person;
import hid.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	private Person person = new Person();
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showPersonsPage() {
		ModelAndView model = new ModelAndView("persons");
		model.addObject("person", person);
		model.addObject("personsList", personService.getAllPersons());
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addPerson(@Valid Person person, BindingResult result) {
		if (result.hasErrors()) {
			return showPersonsPage().getViewName();
		}
		personService.saveOrUpdate(person);
		return "redirect:/persons";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam long id) {
		personService.delete(id);
		return "redirect:/persons";
	}	
}
