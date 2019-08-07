package com.control.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.Default_Handler;

public class Logout_Handler implements Default_Handler {
	
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		System.out.println("- Logout_Handler action");
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return null;
	}
}