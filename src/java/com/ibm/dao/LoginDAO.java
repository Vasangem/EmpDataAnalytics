/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dao;


import com.ibm.util.DataBaseConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vasangem
 */
public class LoginDAO {
    public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		/*Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/db_emp","root","root");  
*/
		try {
			con = DataBaseConnector.getConnection();
			ps = con.prepareStatement("Select uname, password from Users where uname = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataBaseConnector.close(con);
		}
		return false;
	}
}
