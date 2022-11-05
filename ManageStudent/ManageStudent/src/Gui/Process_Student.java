package Gui;

import java.awt.Checkbox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.element.NestingKind;
import javax.security.auth.login.FailedLoginException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Process_Student {
	private static Connection cn = null;
	private static List<String> data = new ArrayList<>();

	
	public static Connection getCon() {
		String URL = "jdbc:mysql://localhost:3306/student_manage";
		String username = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(URL,username,password);
			System.out.println("Connect successful");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connect failure");
			e.printStackTrace();
		}
		return cn;
	}
	
	public ArrayList<Student> getListStudent() {
		Connection connection = getCon();
		ArrayList<Student> sList = new ArrayList<>();
		String sql = "select * from student";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Student student = new Student();
				student.setID(rs.getString("ID"));
				student.setName(rs.getString("Name"));
				student.setClassID(rs.getString("ClassID")); 
//				String gender = rs.getString("Gender");
//				boolean b = true;
//				if(gender.equals("Female")) b = false;
//				student.setGender(b);
				student.setGender(rs.getBoolean("Gender"));
				student.setMark(rs.getDouble("Mark"));
				sList.add(student);
				
			}
			return sList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
 	}
	
	public ArrayList<Student> getStudent_byClass(String classID){
		ArrayList<Student> cList = new ArrayList<>();
		return cList;
	}
	
	public boolean insertStudent(Student s) {
		try {
			String gender = null;
			if(s.isGender() == true)
				gender = "Male";
			else{
				gender = "Female";
			} 
			Connection connection = getCon();
			String sql = "insert into student(ID, Name, ClassID, Gender, Mark)" + "value(?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, s.getID());
			stmt.setString(2, s.getName());
			stmt.setString(3, s.getClassID());
			stmt.setString(4, gender);
			stmt.setDouble(5, s.getMark());
			stmt.execute();
			cn.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean updateStudent(Student s) {
		try {
			String gender = null;
			if(s.isGender() == true)
				gender = "Male";
			else{
				gender = "Female";
			} 
			Connection connection = getCon();
			String sql = "Update student set Name=?, ClassID=?, Gender=?, Mark=? where ID=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getClassID());
			pstmt.setString(3, gender);
			pstmt.setDouble(4, s.getMark());
			pstmt.setString(5, s.getID());
			pstmt.executeUpdate();
			connection.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	public boolean deleteStudent(String ID) {
		try {
			Connection connection = getCon();
			String sql = "Delete from student where ID=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, ID);
			pstmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "success");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	public ArrayList<Student> getListStudent(String classID) {
		Connection connection = getCon();
		ArrayList<Student> sList = new ArrayList<>();
		String sql = "select * from student";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Student student = new Student();
				student.setID(rs.getString("ID"));
				student.setName(rs.getString("Name"));
				student.setClassID(rs.getString("ClassID")); 
//				String gender = rs.getString("Gender");
//				boolean b = true;
//				if(gender.equals("Female")) b = false;
//				student.setGender(b);
				student.setGender(rs.getBoolean("Gender"));
				student.setMark(rs.getDouble("Mark"));
				sList.add(student);
				
			}
			return sList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
 	}
	
//	public Student get() {
//		try {
//			Connection connection = getCon();
//			String sql = "Select * from "
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	public void showcbBClass(JComboBox a) {
		List<String> data = Process_Student.getData();
		for (String s : data) {
			a.addItem(s);
		}
	}
	
	public static List<String> getData(){
		data.add("Th1");
		data.add("Th2");
		data.add("Th3");
		data.add("Th4");
		data.add("Th5");
		data.add("Th6");
		data.add("Th7");
		data.add("Th8");
		data.add("Th9");
		data.add("Th10");
		data.add("Pm1");
		data.add("Pm2");
		return data;
	}

	public static void main(String[] args) {
//		Process_Student aProcess_Student = new Process_Student();
//		ArrayList<Student> a= new ArrayList<>();
//		a=aProcess_Student.getListStudent();
//		System.out.println(a);
		
		
	}
}
