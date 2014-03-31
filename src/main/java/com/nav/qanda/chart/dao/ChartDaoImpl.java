package com.nav.qanda.chart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChartDaoImpl implements ChartDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
		
	
	
@Override
public Map<String, Long> getAnswersAndCount(Long questionId) {
	HashMap<String, Long> results = new HashMap<String,Long>();
	String SQL="Select answer, count(*) as votes from user_responses where question_id=? group by answer";
	List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL, new Object[]{questionId}) ;
	byte[] tempMemberIds = null;
	String tempSearscc = null;
	if ((rows != null) || (rows.size() > 0)) {
    for (Map<String, Object> tempRow : rows) {
    	results.put(tempRow.get("answer").toString(), new Long(tempRow.get("votes").toString()));
    }
} else {
    //do something else
}
	return results;
}
}
