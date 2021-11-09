package com.wavelabs.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.wavelabs.Beans.RegisterBean;

public class RegisterDao {

	public String authorizeRegister(RegisterBean registerBean) {
		// TODO Auto-generated method stub

		String name = registerBean.getName();
		String mobile = registerBean.getMobile();
		String email = registerBean.getEmail();
		String address = registerBean.getAddress();
		String username = registerBean.getUserName();
		String password = registerBean.getPassword();

		String url = "jdbc:mysql://localhost:3306/db_mvc_login";
		String uname = "root";
		String pass = "Vspk1998@";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);

			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(
					"insert into user(name,mobile,email,address,username,password)" + "values(?,?,?,?,?,?)");

			pstmt.setString(1, name);
			pstmt.setString(2, mobile);
			pstmt.setString(3, email);
			pstmt.setString(4, address);
			pstmt.setString(5, username);
			pstmt.setString(6, password);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Fail Register";
	}

}