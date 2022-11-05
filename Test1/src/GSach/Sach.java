package GSach;

public class Sach extends Tailieu {
	private int NamXB;
	private int GiaB;

	
	public Sach() {
		super();
	}


	public Sach(int MaS, String TenS) {
		super(MaS, TenS);
		NamXB = namXB;
		GiaB =  giaB;
		
	}
	public int getNamXB() {
		return NamXB;
	}
	public void setNamXB(int namXB) {
		NamXB =namXB;
	}
	public int getGiaB() {
		return GiaB;
	}

	public void setGiaB(int giaB) {
		GiaB = giaB;
	}

	@Override
	public int Thanhtien() {
		if (NamXB < 2015) {
			return this.GiaB * 85 / 100;
		} else {
			return this.GiaB * 95 / 100;
		}
		
	}

	
	

}
