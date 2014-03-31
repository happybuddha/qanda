package com.nav.qanda.poll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nav.qanda.poll.dao.PollDao;
import com.nav.qanda.poll.domain.Qanda;

@Service
@Transactional
public class PollServiceImpl implements PollService{
	@Autowired
	PollDao pollDao;

	@Override
	public Qanda fetchPollById(Long id) {
		return pollDao.fetchPollById(id);
	}

	@Override
	public String registerUserVote(Qanda qandaPoll, Long uId) {
		return pollDao.registerUserVote(qandaPoll, uId);
	}

}
