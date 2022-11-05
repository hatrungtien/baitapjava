package GLuong;

public class Person {
	private String MaNV;
	private String Hoten;
	@Override
	public String toString() {
		return "Person [MaNV=" + MaNV + ", Hoten=" + Hoten + "]";
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public Person(String maNV, String hoten) {
		super();
		MaNV = maNV;
		Hoten = hoten;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
}
