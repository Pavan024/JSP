package com.wavelabs.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wavelabs.Beans.LoginBean;
import com.wavelabs.Dao.LoginDao;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (request.getParameter("btn_login") != null) {

			String username = request.getParameter("txt_username");
			String password = request.getParameter("txt_password");

			LoginBean lb = new LoginBean();
			lb.setUserName(username);
			lb.setPassword(password);

			LoginDao dao = new LoginDao();
			String authorize = dao.authorizeLogin(lb);

			if (authorize.equals("Success")) {
				HttpSession session = request.getSession();
				session.setAttribute("login", lb.getUserName());
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("WrongLoginMsg", authorize);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
	}
}
