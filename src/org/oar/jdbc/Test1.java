package org.oar.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry="insert into oecm2.student values(26,'kavya',827496)";
		//String qry="delete from oecm2.student where name='satya'";
		//String qry="update oecm2.student set name='satya' where name='kavya'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("connection established");
			stmt=con.createStatement();
			System.out.println("plateform created");
			stmt.executeUpdate(qry);
			System.out.println("row inserted");
			//System.out.println("row deleted");
			//System.out.println("row updated");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null && stmt!=null)
				try {
					con.close();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
