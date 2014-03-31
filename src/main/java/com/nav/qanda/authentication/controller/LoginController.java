package com.nav.qanda.authentication.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nav.qanda.admin.question.domain.Qanda;
import com.nav.qanda.authentication.domain.User;
import com.nav.qanda.authentication.service.UserService;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	UserService usc;
	
 @RequestMapping(value="/login", method = RequestMethod.GET)
 public String executeSecurity(ModelMap model, Principal principal ) {
 
/*  String name = principal.getName();
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String name = user.getUsername();
  model.addAttribute("author", name);
  model.addAttribute("message", "Welcome To Login Form Based Spring Security !!!");*/
  return "login";
 
 }
 
 @RequestMapping(value="/submitLogin", method = RequestMethod.POST)
 public ModelAndView login(@ModelAttribute User user) {
	 user = usc.login(user);
	 System.out.println("User id is "+user.getUserId());
	 ModelAndView modelAndView = new ModelAndView();
     modelAndView.setViewName("/index");
     modelAndView.addObject("user", user);
	 return modelAndView;
 }
 
 @RequestMapping(value="/loginFailed", method = RequestMethod.GET)
 public String loginerror(ModelMap model) {
 
  model.addAttribute("error", "true");
  return "login";
 
 }
 
 @RequestMapping(value="/logout", method = RequestMethod.GET)
 public String logout(ModelMap model) {
 
  return "login";
 
 }
 @ModelAttribute("user")
 public User createModel() {
     return new User();
 }
}

