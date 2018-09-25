package com.tagore.springdemo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tagore.springdemo.domain.Address;

@Controller
public class ModelAttributeDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(ModelAttributeDemoController.class);

	@RequestMapping(value = "/home")
	public String home() {
		LOGGER.info("Inside home: " + System.currentTimeMillis());
		return "modelAttributeHome";
	}

	@RequestMapping(value = "/home2")
	public ModelAndView home2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modelAttributeHome");
		mav.addObject("command", new Address());
		return mav;
	}

	@RequestMapping(value = "/home3")
	public ModelAndView home3() {
		ModelAndView mav = new ModelAndView("modelAttributeHome");
		mav.addObject("anAddress", new Address());
		return mav;
	}

	@RequestMapping(value = "/home4")
	public ModelAndView home4() {
		return new ModelAndView("modelAttributeHome", "anAddress", new Address("Melbourne", "3500"));
	}

	@RequestMapping(value = "/home5")
	public String home5(Model model) {
		model.addAttribute("anAddress", new Address("Brisbane", "5000"));
		return "modelAttributeHome";
	}

	// Usage of ModelAttribute on a method with multiple attributes
	@ModelAttribute
	public void ModelAttributeTest1(Model model) {
		LOGGER.info("Inside ModelAttributeTest1: " + System.currentTimeMillis());
		model.addAttribute("testData1A", "Welcome to the @ModelAttribute Test Bed");
		model.addAttribute("testData1B", "We will test usages on methods and method arguements");
	}

	// Usage of ModelAttribute on a method using 'name' attribute
	@ModelAttribute(name = "testdata2")
	public String ModelAttributeTest2() {
		LOGGER.info("Inside ModelAttributeTest2: " + System.currentTimeMillis());
		return "We will conduct series of tests here";
	}

	// Usage of ModelAttribute on a method using 'value' attribute and java object
	@ModelAttribute(value = "testdata3")
	public Address ModelAttributeTest3() {
		LOGGER.info("Inside ModelAttributeTest3: " + System.currentTimeMillis());
		return new Address("Adelaide", "5000");
	}

	// Usage of ModelAttribute on a method - default naming strategy
	@ModelAttribute
	public Address ModelAttributeTest4() {
		LOGGER.info("Inside ModelAttributeTest4: " + System.currentTimeMillis());
		return new Address("Sydney", "2000");
	}
	
	//Usage of ModelAttribute with 'value' attribute and default binding
	@RequestMapping(value="/test5", method=RequestMethod.POST)
	public String ModelAttributeTest5(@ModelAttribute(value="anAddress")Address address, ModelMap model) {
		model.addAttribute("testdata5A", address.getCity());
		model.addAttribute("testdata5B", address.getZipCode());
	return "modelAttributeTest";	
	}
	
	//Test to determine the nature of how @ModelAttribute(on method) and @RequestMapping
	//work with no explicit logic view name
	@RequestMapping(value="/modelAttributeTest")
	@ModelAttribute("testdata6")
	public Address modelAttributeTest6() {
		return new Address("Canberra", "2600");
	}
}
