package com.nav.qanda.poll.service;

import com.nav.qanda.poll.domain.Qanda;


public interface PollService {
	public Qanda fetchPollById(Long id);
	public String registerUserVote(Qanda qandaPoll, Long uId);
}
