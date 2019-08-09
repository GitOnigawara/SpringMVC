package com.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dao.MemberDAO;

@Configuration
public class DBConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/dbSessionName?characterEncoding=utf8");
		ds.setUsername("username");
		ds.setPassword("password");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		
		/*
		 * ds.setTestWhileIdle(true); 유휴 커낵션 검사
		 * ds.setMiEvictableIdleTimeMillis(1000 * 60 * 3); 최소 유휴시간 3분
		 * ds.setTimeBetweenEvictionRunsMillis(1000 * 10); 10초 주기로
		 */
		
		return ds;
	}
	
	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAO(dataSource());
	}
	
}
