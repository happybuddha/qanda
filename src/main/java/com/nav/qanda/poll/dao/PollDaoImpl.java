package com.nav.qanda.poll.dao;

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

import com.nav.qanda.poll.domain.QandARowMapper;
import com.nav.qanda.poll.domain.Qanda;

@SuppressWarnings("unchecked")
@Repository
public class PollDaoImpl implements PollDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public com.nav.qanda.poll.domain.Qanda fetchPollById(Long id) {
		String sql = "SELECT * FROM qanda WHERE id = ?";
		com.nav.qanda.poll.domain.Qanda q = (com.nav.qanda.poll.domain.Qanda)jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new QandARowMapper());
		return q;
	}

	@Override
	public String registerUserVote(Qanda qandaPoll, Long uId) {
		System.out.println("Entering in to DB");
		System.out.println(uId + qandaPoll.getId() + qandaPoll.getUsersResponse());
		final String SQL = "INSERT INTO qandapoll.user_responses(user_id,question_id, answer) VALUES(?, ?, ?)";
	try{
		jdbcTemplate.update(SQL, new Object[] { uId, qandaPoll.getId(), qandaPoll.getUsersResponse()});
	}catch(Exception e){
		e.printStackTrace();
	}
	return null;
	}
	}

