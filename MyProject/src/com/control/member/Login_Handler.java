package com.control.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.Default_Handler;
import com.model.Member;

public class Login_Handler implements Default_Handler {
	private String view = "index.jsp";
	private String content_path;
	
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		System.out.println("Login_Handler action");
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			String id = request.getParameter("m_id");
			String pw = request.getParameter("m_pw");
			request.getSession().setAttribute("member", id);
			content_path	= "../content/management/main.jsp";
		}
		
		request.setAttribute("content_path", content_path);
		return view;
	}
}
