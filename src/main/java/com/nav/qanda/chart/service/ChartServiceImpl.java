package com.nav.qanda.chart.service;

import java.util.Map;

import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nav.qanda.chart.dao.ChartDao;

@Service
public class ChartServiceImpl implements ChartService {
	@Autowired
	ChartDao cDao;
	
	@Override
	public DefaultPieDataset getPollData(Long questionId) {
		//Fetch poll answer options
		//Fetch number of user responses for each of those answers 
		DefaultPieDataset result = new DefaultPieDataset();
		Map<String, Long> answerVotes = cDao.getAnswersAndCount(questionId); 
		for (Map.Entry<String, Long> entry : answerVotes.entrySet()) {
			result.setValue(entry.getKey(), entry.getValue());
		}
		return result;
	}

}
