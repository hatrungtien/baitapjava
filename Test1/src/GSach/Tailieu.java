package GSach;

public class Tailieu {
	private int MaS;
	private String TenS;

	public Tailieu() {
		
	}
	public Tailieu(int MaS, String TenS) {
		this.MaS = MaS;
		this.TenS = TenS;
	}
	public int getMaS() {
		return MaS;
	}
	public void setMaS(int maS) {
		MaS = maS;
	}
	public String getTenS() {
		return TenS;
	}
	public void setTenS(String tenS) {
		TenS = tenS;
	}
	abstract public int Thanhtien();

}
