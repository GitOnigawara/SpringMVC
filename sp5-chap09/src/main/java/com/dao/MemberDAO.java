package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.model.Member;

public class MemberDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
		List<Member> result = jdbcTemplate.query(
			"SELECT * FROM member WHERE email = ?",
			new RowMapper<Member>() {
				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Member member = new Member(
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getTimestamp("regdate").toLocalDateTime()
					);
					member.setId(rs.getLong("id"));
					return member;
				}
			},
			email
		);
		return result.isEmpty() ? null : result.get(0);
	}
	
	public void insert(Member member) {
		
	}
	
	public void update(Member member) {
		
	}
	
	public List<Member> selectAll() {
		List<Member> result = jdbcTemplate.query(
			"SELECT * FROM member",
			new RowMapper<Member>() {
				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Member member = new Member(
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getTimestamp("regdate").toLocalDateTime()
					);
					member.setId(rs.getLong("id"));
					return member;
				}
			}
		);
		return result;
	}
	
}
