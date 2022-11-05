package GSach;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {
       private static String URL = "jdbc:mysql://localhost:3306/dlsach";
       private static String User_Name = "root";
       private static String PASSWORD ="";
       
	public static void main(String[] args) {
		try {
			Connection conn = getConnection(URL,User_Name,PASSWORD);
			Statement  stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select * from tbsach ");
			while (rs.next()) {
				System.out.println(rs.getInt(1) +" "+rs.getString(2)+ " "+ rs.getString(3)+ " " +rs.getString(4));
			} 
			conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		

	}
	public static Connection getConnection(String dbURL,String userName,String password  ) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
		}
	}


