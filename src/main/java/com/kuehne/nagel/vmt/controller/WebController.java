package com.kuehne.nagel.vmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
	@RequestMapping(value={"/","home"})
	public ModelAndView home(){
		System.out.println("--------------> home");
		//return "home";
		return new ModelAndView("home.jsf","WelcomeMessage","Welcome!");
	}
	
	@RequestMapping(value={"/welcome"})
	public ModelAndView welcome(){
		System.out.println("--------------> welcome");
		//return "welcome";
		return new ModelAndView("welcome.jsf","WelcomeMessage","Welcome!");
	}

	@RequestMapping(value="/admin")
	public String admin(){
		System.out.println("--------------> admin");
		return "admin";
	}
	
	@RequestMapping(value={"/login"})
	public ModelAndView login(){
		System.out.println("--------------> login");
		//return "login";
		return new ModelAndView("login.jsf","WelcomeMessage","Welcome!");
	}
	
	
	@RequestMapping(value="/403")
	public String Error403(){
		System.out.println("--------------> 403");
		return "403";
	}
}
