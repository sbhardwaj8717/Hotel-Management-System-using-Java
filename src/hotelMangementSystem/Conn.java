package hotelMangementSystem;

import java.sql.*;														// database import
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;



public class Conn {
	Connection c;			// interface to connect with database
	Statement s;			// interface of query 
	
	public Conn() {			// constructor
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 																// Driver of the MySQL
			c= DriverManager.getConnection("jdbc:mysql:///projecthms","root","nva24f54^#@D5#$2");					// Connecting the database
			s = c.createStatement();																				// queries 
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
