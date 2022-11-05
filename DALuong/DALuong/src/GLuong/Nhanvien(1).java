package GLuong;

public class Nhanvien extends Person {
	private String Diachi;
	private double Luong;

	public Nhanvien() {
	}

	@Override
	public String toString() {
		return "Nhanvien [MaNV= " + getMaNV() + ", Hoten= " + getHoten() + " ,Diachi=" + Diachi + ", Luong=" + Luong + "]\n";
	}
	

	public Nhanvien(int MaNV, String Hoten, String diachi, double luong) {
		super(MaNV, Hoten);
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

}
