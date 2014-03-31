package com.nav.qanda.poll.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class QandARowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Qanda q = new Qanda();
		q.setId(rs.getLong("id"));
		q.setQuestionText(rs.getString("questionText"));
		q.setQuestionAnswerA(rs.getString("questionAnswerA"));
		q.setQuestionAnswerB(rs.getString("questionAnswerB"));
		q.setQuestionAnswerC(rs.getString("questionAnswerC"));
		q.setQuestionAnswerD(rs.getString("questionAnswerD"));
		return q;
	}

}
