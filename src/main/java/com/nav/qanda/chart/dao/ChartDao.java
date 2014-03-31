package com.nav.qanda.chart.dao;

import java.util.Map;

public interface ChartDao {

	Map<String, Long> getAnswersAndCount(Long questionId);

}
