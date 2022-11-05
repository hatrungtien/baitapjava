package GLuong;

import java.util.Date;

public class Nhanvien extends Person {
	private String Diachi;
	private double Luong;
	private java.sql.Date birth;
	public java.sql.Date getBirth() {
		return birth;
	}
	public Nhanvien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Nhanvien(String maNV, String hoten) {
		super(maNV, hoten);
		// TODO Auto-generated constructor stub
	}
	public Nhanvien(String maNV, String hoten, String diachi, double luong) {
		super(maNV, hoten);
		Diachi = diachi;
		Luong = luong;
	}
	public String getDiachi() {
		return Diachi;
	}
	public void setDiachi(String diachi) {
		Diachi = diachi;
	}
	public double getLuong() {
		return Luong;
	}
	public void setLuong(double luong) {
		Luong = luong;
	}
	@Override
	public String toString() {
		return "Nhanvien [Ma=" + getMaNV() + ", Ten=" + getHoten() +  ", Diachi=" + Diachi + ", Luong=" + Luong  + "]";
	}
	public void setBirth(java.sql.Date date) {
		// TODO Auto-generated method stub
		this.birth = date;
	}
	
}
