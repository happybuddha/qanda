package com.nav.qanda.authentication.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nav.qanda.authentication.domain.User;
import com.nav.qanda.poll.domain.QandARowMapper;

@Repository
public class UserDaoImpl implements UserDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public User login(User u) {
		String sql = "Select id from users u where u.userName = ? and u.password=?";
		Long id = 0l; 
		id = (Long)jdbcTemplate.queryForObject(sql, new Object[] { u.getUserN(), u.getUserP()}, Long.class);
		u.setUserId(id);
		return u;
	}

}
