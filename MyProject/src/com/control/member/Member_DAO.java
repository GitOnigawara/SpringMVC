package com.control.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Member;

public class Member_DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Boolean check(String m_id) throws SQLException, IOException {
		System.out.println("- Member_DAO check");
		
		String sql = "SELECT * FROM member WHERE m_id = ?";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:customer");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			if(pstmt.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} finally {
			conn.close();
		}
	}
	
	
	public void insert(Member member) throws SQLException, IOException {
		System.out.println("- Member_DAO insert");
		
		String sql = "INSERT INTO tbl_member(m_idx, m_id, m_pw, m_mail, reg_date, mod_date) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:customer");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1, getMax() + 1);
			pstmt.setString(2, member.getM_id());
			pstmt.setString(3, member.getM_pw());
			pstmt.setString(4, member.getM_email());
			pstmt.setTimestamp(5, toDate());
			pstmt.setTimestamp(6, toDate());
		} finally {
			conn.close();
		}
	}
	
	public Member select(Member member) throws SQLException, IOException {
		System.out.println("- Member_DAO select");
		
		String sql = "SELECT * FROM member WHERE m_id = ? AND m_pw = ?";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:customer");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, member.getM_id());
			pstmt.setString(2, member.getM_pw());
			rs		= pstmt.executeQuery();
			while(rs.next()) {
				member = new Member(
					rs.getString("m_idx"),
					rs.getString("m_id"),
					rs.getString("m_pw"),
					rs.getString("m_email"),
					new Date(rs.getTimestamp("reg_date").getTime()),
					new Date(rs.getTimestamp("mod_date").getTime())
				);
			}
			
			return member;
		} finally {
			conn.close();
		}
	}
	
	public List<Member> selectAll() throws SQLException, IOException {
		System.out.println("- Member_DAO selectAll");
		List<Member> list = new ArrayList<Member>();
		
		String sql = "SELECT * FROM tbl_member";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:customer");
			pstmt	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			while(rs.next()) {
				Member temp = new Member(
						rs.getString("m_idx"),
						rs.getString("m_id"),
						rs.getString("m_pw"),
						rs.getString("m_email"),
						new Date(rs.getTimestamp("reg_date").getTime()),
						new Date(rs.getTimestamp("mod_date").getTime())
				);
				list.add(temp);
			}
			return list;
		} finally {
			conn.close();
		}
	}
	
	public void update(Member member) throws SQLException, IOException {
		System.out.println("- Member_DAO update");
		
		String sql = "UPDATE tbl_member SET m_pw = ?, m_email = ? WHERE m_id = ?";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:customer");
			pstmt	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
		} finally {
			conn.close();
		}
	}
	
	public int getMax() throws SQLException {
		System.out.println("- Member_DAO idx");
		int num = 1;
		String sql = "SELECT MAX(m_idx) AS max FROM tbl_member";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:customer");
			pstmt	= conn.prepareStatement(sql);
			if(pstmt.executeUpdate() > 0) {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					num = rs.getInt("max");
				}
			}
			return num;
		} finally {
			conn.close();
		}
	}
	
	public Timestamp toDate() {return new Timestamp(System.currentTimeMillis());}
}
