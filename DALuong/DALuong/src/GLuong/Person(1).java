package GLuong;

public class Person {
	private int MaNV;
	private String Hoten;
	@Override
	public String toString() {
		return "Person [MaNV=" + MaNV + ", Hoten=" + Hoten + "]";
	}
	public Person() {}
	public Person(int maNV, String hoten) {
		MaNV = maNV;
		Hoten = hoten;
	}
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	
}
