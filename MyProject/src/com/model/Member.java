package com.model;

import java.util.Date;

public class Member {
	private String m_idx;
	private String m_id;
	private String m_pw;
	private String m_email;
	private Date reg_date;
	private Date mod_date;
	public Member() {}
	public Member(String m_idx, String m_id, String m_pw, String m_email, Date reg_date, Date mod_date) {
		super();
		this.m_idx = m_idx;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_email = m_email;
		this.reg_date = reg_date;
		this.mod_date = mod_date;
	}
	public String getM_idx() {
		return m_idx;
	}
	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getMod_date() {
		return mod_date;
	}
	public void setMod_date(Date mod_date) {
		this.mod_date = mod_date;
	}
}
