package com.employee.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employee.dao.EmployeeDao;
import com.employee.model.EmployeePOJO;
@RestController
@RequestMapping("/emp")
public class EmployeeController 
{
	@Autowired
	public EmployeeDao empDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showStartPage(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showHomePage(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		System.out.println("REGISTER..");
		mav.addObject("employee", new EmployeePOJO());
		return mav;
	}
	
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("employee") EmployeePOJO emp) {
		System.out.println("Hello" +emp.getFirstname());
		empDao.register(emp);
		return new ModelAndView("welcome", "firstname", emp.getFirstname());
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listEmployees(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("list");
		System.out.println("Showing list..");
		List<EmployeePOJO> eList = empDao.listAll();
		mav.addObject("eList", eList);
		return mav;
	}
}