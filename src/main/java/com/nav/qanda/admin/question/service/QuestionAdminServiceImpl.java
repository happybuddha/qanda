package com.nav.qanda.admin.question.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nav.qanda.admin.question.dao.QuestionDao;
import com.nav.qanda.admin.question.domain.Qanda;

@Service
@Transactional
public class QuestionAdminServiceImpl implements QuestionAdminService{
	@Autowired
	QuestionDao qandaDao;
	
	@Override
	public String createQanda(Qanda q) {
		return qandaDao.createQanda(q);
	}

}
