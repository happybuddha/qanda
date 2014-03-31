package com.nav.qanda.chart.service;

import org.jfree.data.general.DefaultPieDataset;

public interface ChartService {
	DefaultPieDataset getPollData(Long questionId);
}
