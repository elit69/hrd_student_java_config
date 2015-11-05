package com.lit.hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lit.hw.entities.Student;
import com.lit.hw.services.StudentService;


@Controller
public class MainController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/" ,  method = RequestMethod.GET)
	public String homePage(ModelMap model){
		//model.addAttribute("delete_status", delete_status);
		model.addAttribute("listStudent", studentService.list());
		System.out.println("home page");
		return "home";
	}
	
	@RequestMapping(value = "/add" ,  method = RequestMethod.GET)
	public String addPage(ModelMap model){
		System.out.println("add page");
		return "add";
	}

	@RequestMapping(value = "/add" ,  method = RequestMethod.POST)
	public String add(@ModelAttribute(value="stu")Student stuobj){
		System.out.println("add action " + stuobj.getFirstname());
		studentService.add(stuobj);
		return "redirect:/";
	}

	@RequestMapping(value = "/update/{id}" ,  method = RequestMethod.GET)
	public String updatePage(ModelMap model, @PathVariable int id){
		System.out.println("update page" + id);
		model.addAttribute("stu",studentService.show(id));
		return "update";
	}
	
	@RequestMapping(value = "/update" ,  method = RequestMethod.POST)
	public String update(@ModelAttribute(value="stu1")Student stuobj){
		System.out.println("update action " + stuobj.getId());
		studentService.update(stuobj);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete/{id}" ,  method = RequestMethod.GET)
	public String delete(@PathVariable int id){
		System.out.println("delete action" + id);
		studentService.delete(id);		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/show/{id}" ,  method = RequestMethod.GET)
	public String showPage(ModelMap model, @PathVariable int id){
		System.out.println("show page " + id);
		model.addAttribute("stu", studentService.show(id));
		return "show";
	}
	
	@RequestMapping(value = "/search" ,  method = RequestMethod.GET)
	public String searchPage(ModelMap model){
		System.out.println("search page");
		return "search";
	}	
	
	@RequestMapping(value = "/search" ,  method = RequestMethod.POST)
	public String searchAction(ModelMap model,
			@RequestParam(value="keyword", required=true) String keyword,
			@RequestParam(value="type", required=true) String type
			){
		System.out.println("search action " + keyword + " " + type);
		model.addAttribute("listResult", studentService.search(keyword, type));
		return "search";
	}	

	
}
