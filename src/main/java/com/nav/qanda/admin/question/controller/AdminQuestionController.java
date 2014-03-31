package com.nav.qanda.admin.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nav.qanda.admin.question.domain.Qanda;
import com.nav.qanda.admin.question.service.QuestionAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin")
public class AdminQuestionController {
	@Autowired
	QuestionAdminService qnaSrvc;
	
	 /**
	   * This method handles returning adding of question and answer page
	   */
	  @RequestMapping(value = "/createQandaPage", method = RequestMethod.GET)
	  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	       return new ModelAndView("admin/createQanda");
	   }
	  
	  @RequestMapping(value = "/createQandA")
	  public ModelAndView createPart1NewForm(@ModelAttribute Qanda qanda)
	  {
		  qnaSrvc.createQanda(qanda);
		  String s = "link";
		  return new ModelAndView("admin/shareQandaLink");
	  }
	  
//	  private String generatePollLink(){
//		  
//	  }
	  
	  @ModelAttribute("qanda")
	  public Qanda createModel() {
	      return new Qanda();
	  }
}
