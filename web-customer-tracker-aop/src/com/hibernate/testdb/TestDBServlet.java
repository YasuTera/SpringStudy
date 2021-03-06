package com.hibernate.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet(name = "TestDbServlet", urlPatterns = { "/TestDbServlet" })
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DB接続設定
		String user = "springstudent";
		String pass = "springstudent";
		
		String dbUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//c 接続処理
		try {
			PrintWriter o = response.getWriter();
			o.println("接続先: " + dbUrl);
			
			Class.forName(driver);
			Connection c = DriverManager.getConnection(dbUrl, user, pass);
			
			o.println("接続成功");
			c.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
