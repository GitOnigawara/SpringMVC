package com.control;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class Connection_Pool extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		jdbcDriver();
		connectionPool();
		System.out.println("connection pool inited");
	}
	
	private void jdbcDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e ) {
			throw new RuntimeException("driver load fail", e); 
		}
	}
	
	private void connectionPool() {
		try {
			String url	= "jdbc:oracle:thin:@localhost:1521:orcl";
			String id	= "onigawara";
			String pw	= "dbwls12";
			ConnectionFactory cf = new DriverManagerConnectionFactory(url, id, pw);			
			PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf,null);	
			GenericObjectPoolConfig<PoolableConnection> gopc = new GenericObjectPoolConfig<PoolableConnection>();
			gopc.setTimeBetweenEvictionRunsMillis(60000L*5L);
			gopc.setMinIdle(5);
			gopc.setMaxTotal(100);
			gopc.setTestWhileIdle(true);
			GenericObjectPool<PoolableConnection> gop = new GenericObjectPool<PoolableConnection>(pcf,gopc);
			pcf.setPool(gop);
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("customer", gop);
		}catch(Exception e) {
			System.out.print(e);
		}
	}
}