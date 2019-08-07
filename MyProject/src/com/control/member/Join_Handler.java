package com.control.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.Default_Handler;

public class Join_Handler implements Default_Handler {
	private String content_path;
	
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		System.out.println("Join_Handler action");
		
		content_path	= "../content/member/login.jsp";
		request.setAttribute("content_path", content_path);
		response.sendRedirect(request.getContextPath());
		return null;
	}
}