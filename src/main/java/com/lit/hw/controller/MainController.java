package com.lit.hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = {"/","home"} ,  method = RequestMethod.GET)
	public String homePage(ModelMap model){
		model.addAttribute("message","Hello Home Page");
		return "home";
	}
	
	@RequestMapping(value = "about" ,  method = RequestMethod.GET)
	public String aboutPage(ModelMap model){
		model.addAttribute("message","Hello About Page");
		return "about";
	}
	
}
