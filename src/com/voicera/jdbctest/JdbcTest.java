package com.voicera.jdbctest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class JdbcTest
 */
@WebServlet("/JdbcTest")
public class JdbcTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "springstudent";
		String pass = "manager";
		
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("\nconnecting to the database: "+ url + "\n");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, pass);
			
			out.println("Connection successful......!");
			
			con.close();
			
		} catch (Exception exe) {
			exe.printStackTrace();
			throw new ServletException(exe);
		}
	}

}
