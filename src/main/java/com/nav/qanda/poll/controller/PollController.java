package com.nav.qanda.poll.controller;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nav.qanda.admin.question.controller.CryptoController;
import com.nav.qanda.authentication.domain.User;
import com.nav.qanda.poll.domain.Qanda;
import com.nav.qanda.poll.service.PollService;

@Controller
@SessionAttributes({"user"})
public class PollController {
	@Autowired
	PollService pollSrvc; 
	@Autowired
	CryptoController crypt;
	
	@RequestMapping("/poll/{id}")
	public ModelAndView getPollPage(@PathVariable("id") Long id) {
		Qanda questionNAns = new Qanda();
		System.out.println("Fetching poll by question id"+id);
		questionNAns = pollSrvc.fetchPollById(id);
		return new ModelAndView("poll/pollScreen", "questionNAns", questionNAns);  
	}
	@RequestMapping("/poll/registerAnswer")
	public ModelAndView regPollAnswer(@ModelAttribute Qanda qandaPoll, @ModelAttribute User user){
		System.out.println("Users response is "+qandaPoll.getUsersResponse());
		System.out.println("User Id found in session is userId"+user.getUserId());
		pollSrvc.registerUserVote(qandaPoll, user.getUserId());
		return new ModelAndView("admin/createQanda");
	}
	
	@RequestMapping("/pollLink/{id}")
	public ModelAndView getPollPage(@PathVariable("id") byte[] pollQuestionId) {
		//sample link : /pollLink/[B@1e1246a4
		Qanda questionNAns = new Qanda();
		System.out.println("Fetching poll by question id"+pollQuestionId);
		Long quesId =0L;
		try {
			byte[] decodedBytes = Base64.decodeBase64(pollQuestionId);
			System.out.println("decodedBytes " + new String(decodedBytes));
			quesId = new Long(crypt.decrypt(decodedBytes));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		questionNAns = pollSrvc.fetchPollById(quesId);
		return new ModelAndView("poll/pollScreen", "questionNAns", questionNAns);  
	}
	@ModelAttribute("qandaPoll")
	public Qanda createModel() {
	      return new Qanda();
	}
}
