package Gsach;

import java.sql.*;
import java.util.Iterator;



public class XlSach {

	Connection conn = null;
	public void getCon() {
		try {
		    // db parameters
		    String url       = "jdbc:mysql://localhost:3306/dlsach";
		    String user      = "root";
		    String password  = "";
		     
		    // create a connection to the database
		    conn = DriverManager.getConnection(url, user, password);
		    System.err.println("connect succes!");
		    // more processing here
		    // ...  
		} catch(SQLException e) {
		   System.out.println(e.getMessage());
		}
	}
	
	public void getSA(String a) {
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(a);
			 while (rs.next())
		      {
		        
		        String maS = rs.getString("maS");
		        String tenS = rs.getString("tenS");
		        String namXB = rs.getString("namXB");
		        String giaB = rs.getString("giaB");
		        
		    
		        // print the results
		        System.out.format("%s - %s - %s\n", maS, tenS, namXB, giaB);
		      }
		      st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void deleteSA(String a) {
		try {
			Statement st = conn.createStatement();

			int rs = st.executeUpdate(a);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		XlSach conTestdb = new XlSach();
		conTestdb.getCon();
		conTestdb.deleteSA("DELETE FROM `tbsach` WHERE namXB= 2020;");
		conTestdb.getSA("SELECT * FROM `tbsach`");
		
		
	}
}
