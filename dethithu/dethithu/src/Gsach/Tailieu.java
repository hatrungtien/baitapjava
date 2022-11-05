package Gsach;

public abstract class Tailieu {
	
	public int maSach;
	public String tSach;

	public Tailieu() {
		
	}


	public Tailieu(int maSach, String tSach) {
		super();
		this.maSach = maSach;
		this.tSach = tSach;
	}
	

	public int getMaSach() {
		return maSach;
	}



	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}



	public String getTSach() {
		return tSach;
	}



	public void setTSach(String tbSach) {
		this.tSach = tbSach;
	}

	
	public abstract double Thanhtien(double gia, int nam); 
//	{
//		if (nam>2015) {
//			return gia*0.95;
//		} else {
//			return gia;
//		}
//	}
}
