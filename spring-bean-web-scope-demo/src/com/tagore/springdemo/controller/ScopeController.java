package com.tagore.springdemo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tagore.springdemo.service.RandomizerRequestScope;
import com.tagore.springdemo.service.RandomizerSessionScope;

@Controller
public class ScopeController {

	@Autowired
	RandomizerRequestScope requestScope;
	
	@Autowired
	RandomizerSessionScope sessionScope;
	
	@RequestMapping("/")
	public void getRandom(HttpServletResponse response) throws Exception{
		response.getWriter().write("***************Request Scope*****************" + "<br>");
		response.getWriter().write("Old number: "+ requestScope.getRandomNumber() + "<br>");
		requestScope.generateRandomNumber();
		response.getWriter().write("New number: "+ requestScope.getRandomNumber() + "<br>");
		response.getWriter().write("Object Reference: " + requestScope + "<br>");
	
		response.getWriter().write("***************Session Scope*****************" + "<br>");
		response.getWriter().write("Old number: "+ sessionScope.getRandomNumber() + "<br>");
		sessionScope.generateRandomNumber();
		response.getWriter().write("New number: "+ sessionScope.getRandomNumber() + "<br>");
		response.getWriter().write("Object Reference: " + sessionScope + "<br>");

	
	}
}
