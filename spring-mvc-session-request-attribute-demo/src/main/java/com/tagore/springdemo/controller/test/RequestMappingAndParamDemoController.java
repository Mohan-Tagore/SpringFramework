package com.tagore.springdemo.controller.test;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);

	@RequestMapping(value = "/home")
	public String home() {
		return "requestMappingAndParamHome";
	}

	// Testing @RequestParam with no attributes
	@RequestMapping(value = "/test1")
	public String requestMappingTest1(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test1");
		return "requestMappingAndParamResults";
	}

	// Testing @RequestParam with method attributes
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String requestMappingTest2(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test2");
		return "requestMappingAndParamResults";
	}

	// Testing @RequestParam fallback feature
	// @RequestMapping(value = "*", method = {RequestMethod.GET.
	// RequestMethod.POST})
	@RequestMapping(value = "*", method = RequestMethod.GET)
	public String requestMappingTest3() {
		return "fallback";
	}

	// Testing @RequestParam with default value attribute
	@RequestMapping(value = "/test4")
	public String requestMappingTest4(
			@RequestParam(value = "orgname", defaultValue = "Anonymous Organization") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test4");
		return "requestMappingAndParamResults";
	}

	// Testing @RequestParam without name or value attributes
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String requestMappingTest5(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test5");
		return "requestMappingAndParamResults";
	}

//	// Testing @RequestMapping
//	@RequestMapping(value = "/test6")
//	public String requestMappingTest6SubTest1(@RequestParam String orgname, Model model) {
//		model.addAttribute("orgname", orgname);
//		model.addAttribute("testserial", "test6-subtest1");
//		return "requestMappingAndParamResults2";
//	}

	// Testing @RequestMapping by removing ambiguity
	@RequestMapping(value = "/test6", params = "orgname")
	public String requestMappingTest6SubTest1(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest1");
		return "requestMappingAndParamResults2";
	}

	// Testing @RequestMapping removing ambiguity
	@RequestMapping(value = "/test6", params = "empcount")
	public String requestMappingTest6SubTest2(@RequestParam String empcount, Model model) {
		model.addAttribute("orgname", empcount);
		model.addAttribute("testserial", "test6-subtest2");
		return "requestMappingAndParamResults2";
	}

//	// Testing @RequestMapping
//	@RequestMapping(value = "/test6")
//	public String requestMappingTest6SubTest2(@RequestParam String empcount, Model model) {
//		model.addAttribute("orgname", empcount);
//		model.addAttribute("testserial", "test6-subtest2");
//		return "requestMappingAndParamResults2";
//	}

	// Testing @RequestMapping and @RequestParam with multiple params
	@RequestMapping(value = "/test6/subtest3", method = RequestMethod.GET, params = { "orgname", "empcount" })
	public String requestMappingTest6SubTest3(@RequestParam String orgname, @RequestParam String empcount,
			Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("empcount", empcount);
		model.addAttribute("testserial", "test6-subtest3");
		return "requestMappingAndParamResults2";
	}
	
	// Testing @RequestMapping with multiple params and @RequestParam with single param
		@RequestMapping(value = "/test6/subtest4", method = RequestMethod.GET, params = { "orgname", "empcount" })
		public String requestMappingTest6SubTest4(@RequestParam String orgname, Model model) {
			model.addAttribute("orgname", orgname);
			model.addAttribute("testserial", "test6-subtest4");
			return "requestMappingAndParamResults2";
		}
		
		// Testing @RequestMapping with multiple params with multiple URIs
		@RequestMapping(value = {"/test7", "/test8"}, method = RequestMethod.GET)
		public String requestMappingTest7and8(@RequestParam String orgname, Model model, HttpServletRequest request) {
			model.addAttribute("orgname", orgname);
			LOGGER.info(request.getRequestURL().toString());
			if(request.getRequestURL().toString().contains("test7")) {
				model.addAttribute("testserial", "test7");
			}else {
				model.addAttribute("testserial", "test8");
			}
			return "requestMappingAndParamResults2";
		}
}
