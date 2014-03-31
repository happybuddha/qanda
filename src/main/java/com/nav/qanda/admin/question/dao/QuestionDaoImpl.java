package com.nav.qanda.admin.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.nav.qanda.admin.question.domain.Qanda;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public String createQanda(final Qanda qanda) {
		final String SQL = "INSERT INTO qandapoll.qanda(questionText, questionAnswerA, questionAnswerB, questionAnswerC, questionAnswerD) "
					+ "VALUES (?, ?, ?, ?, ?)"; 
		try{
			KeyHolder keyHolder = new GeneratedKeyHolder();
		/*jdbcTemplateObject.update( SQL, qanda.getQuestionText(), 
										qanda.getQuestionAnswerA(),
										qanda.getQuestionAnswerB(),
										qanda.getQuestionAnswerC(),
										qanda.getQuestionAnswerD());*/
			jdbcTemplate.update(
				    new PreparedStatementCreator() {
				        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				            PreparedStatement ps =
				                connection.prepareStatement(SQL, new String[] {"id"});
				            ps.setString(1, qanda.getQuestionText()); 
				            ps.setString(2, qanda.getQuestionAnswerA());
		            		ps.setString(3, qanda.getQuestionAnswerB());
	            			ps.setString(4, qanda.getQuestionAnswerC());
        					ps.setString(5, qanda.getQuestionAnswerD());
				            return ps;
				        }
				    },
				    keyHolder);
			System.out.println(keyHolder.getKey());
		
		}catch(Exception e){
			e.printStackTrace();
			return "Failure";
		}
	    System.out.println("Created Question");
	    return "Success";
	}

}
