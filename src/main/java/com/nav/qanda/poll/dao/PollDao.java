package com.nav.qanda.poll.dao;

import com.nav.qanda.poll.domain.Qanda;


public interface PollDao {
	com.nav.qanda.poll.domain.Qanda fetchPollById(Long id);
	String registerUserVote(Qanda qandaPoll, Long uId);
}
