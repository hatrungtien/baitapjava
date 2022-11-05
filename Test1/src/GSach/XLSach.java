package GSach;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class XLSach {
	public Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java01", "root", "");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Vector<Vector<String>> getSA() {
		try {
			Vector<Vector<String>> vs = new Vector<Vector<String>>();
			Connection conn = getCon();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM tbSach");
			while (rs.next()) {
				Vector<String> it = new Vector<String>();
				it.add(String.valueOf(rs.getInt(1)));
				it.add(rs.getString(2));
				it.add(String.valueOf(rs.getInt(3)));
				it.add(String.valueOf(rs.getInt(4)));
				vs.add(it);
			}
			conn.close();
			return vs;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean deleteSA(int NamXB) {
		try {
			Connection conn = getCon();
			conn.createStatement().execute("DELETE FROM tbSach WHERE NamXB = " + String.valueOf(NamXB));
			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
