package GDiem;


public class Hocvien {
	private int MaHV;
	private String Hoten;
	private String lop;
	private double Diem;
	
	public Hocvien(int maHV, String hoten, String lop, double diem) {
		super();
		MaHV = maHV;
		Hoten = hoten;
		this.lop = lop;
		Diem = diem;
	}
	public Hocvien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaHV() {
		return MaHV;
	}
	public void setMaHV(int maHV) {
		MaHV = maHV;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public double getDiem() {
		return Diem;
	}
	public void setDiem(double diem) {
		Diem = diem;
	}
	@Override
	public String toString() {
		return "Hocvien [MaHV=" + MaHV + ", Hoten=" + Hoten + ", lop=" + lop + ", Diem=" + Diem + "]";
	}
	public boolean Ketqua() {
		if(this.Diem >= 25) return true;
		return false;
	}
}
