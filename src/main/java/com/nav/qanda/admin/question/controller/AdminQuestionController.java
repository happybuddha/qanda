package com.nav.qanda.admin.question.controller;

import java.io.IOException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nav.qanda.admin.question.domain.Qanda;
import com.nav.qanda.admin.question.service.QuestionAdminService;

import org.apache.commons.codec.binary.Base64;
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
	
	@Autowired
	CryptoController crypt;
	
	 /**
	   * This method handles returning adding of question and answer page
	   */
	  @RequestMapping(value = "/createQandaPage", method = RequestMethod.GET)
	  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	       return new ModelAndView("admin/createQanda");
	   }
	  
	  @RequestMapping(value = "/createQandA")
	  public ModelAndView createPart1NewForm(@ModelAttribute Qanda qanda, HttpServletRequest request) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException
	  {
		  String quesId = qnaSrvc.createQanda(qanda);
		  
		  ModelAndView mav = new ModelAndView();
		  byte[] encodedBytes = Base64.encodeBase64(crypt.encrypt(quesId));
		  System.out.println("encodedBytes " + new String(encodedBytes));
		  
		  mav.addObject("pollLink",getURLWithContextPath(request)+"/pollLink/"+new String(encodedBytes));
		  System.out.println(crypt.encrypt(quesId));
		  System.out.println("when decrypted, it'd be ques id"+crypt.decrypt(crypt.encrypt(quesId)));
		  mav.setViewName("admin/shareQandaLink");
		  return mav;
	  }
	  
//	  private String generatePollLink(){
//		  
//	  }
	  
	  @ModelAttribute("qanda")
	  public Qanda createModel() {
	      return new Qanda();
	  }
	  
	  private String getURLWithContextPath(HttpServletRequest request) {
		   return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		}
}
