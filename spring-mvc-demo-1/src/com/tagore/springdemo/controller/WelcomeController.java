package com.tagore.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tagore.service.demo.GenericWelcomeService;
import com.tagore.service.demo.WelcomeService;

@Controller
public class WelcomeController {

	@Autowired
	private GenericWelcomeService welcomeService;

	@RequestMapping("/")
	// http://localhost:8080/spring-mvc-demo-1/
	public String doWelcome(Model model) {

		//WelcomeService welcomeService = new WelcomeService();
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("Mohan Tagore");

		model.addAttribute("myWelcomeMessage", welcomeMessage);

		return "welcomeNew";

	}
}
