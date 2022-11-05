
package test02;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConnectionJBDC {
    private String URL = "jbdc:mysql://localhost:3306/testdb";
    private String UserName = "root";
    private String PassWord = "" ;
    
   
    public static void main(String args[]){
        try{
            Connection conn = getConnection(URL,UserName,PassWord);
            Statement stm = conn.createStatement();
            ResultSet rs  = stm.executeQuery("select * from student");
            while (rs.next()){
                System.out.print(rs.getInt(1) + "  " + rs.getString(2) 
                        + "  " + rs.getString(3));
            }
             conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     public static Connection getConnection(String dbURL, String userName, 
            String password) {
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