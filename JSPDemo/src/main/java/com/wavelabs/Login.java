package com.wavelabs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		PrintWriter out = response.getWriter();

		if (uname.equals("admin") && pass.equals("admin")) {
			out.println("Successfully logged in");
		} else {
			out.println("Invalid Username or password");
		}
	}

}
