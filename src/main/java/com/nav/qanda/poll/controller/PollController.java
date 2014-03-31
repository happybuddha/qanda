package com.nav.qanda.poll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nav.qanda.authentication.domain.User;
import com.nav.qanda.poll.domain.Qanda;
import com.nav.qanda.poll.service.PollService;

@Controller
@SessionAttributes({"user"})
@RequestMapping("/poll")
public class PollController {
	@Autowired
	PollService pollSrvc; 
	
	@RequestMapping("/{id}")
	public ModelAndView getPollPage(@PathVariable("id") Long id) {
		Qanda questionNAns = new Qanda();
		System.out.println("Fetching poll by question id"+id);
		questionNAns = pollSrvc.fetchPollById(id);
		return new ModelAndView("poll/pollScreen", "questionNAns", questionNAns);  
	}
	@RequestMapping("/registerAnswer")
	public ModelAndView regPollAnswer(@ModelAttribute Qanda qandaPoll, @ModelAttribute User user){
		System.out.println("Users response is "+qandaPoll.getUsersResponse());
		System.out.println("User Id found in session is userId"+user.getUserId());
		pollSrvc.registerUserVote(qandaPoll, user.getUserId());
		return null;
	}
	
	@ModelAttribute("qandaPoll")
	public Qanda createModel() {
	      return new Qanda();
	}
}
