package Gsach;

public class Sach extends Tailieu {
	
	public int nam;
	public double gia;

	
	
	public int getNam() {
		return nam;
	}



	public void setNam(int nam) {
		this.nam = nam;
	}



	public double getGia() {
		return gia;
	}



	public void setGia(double gia) {
		this.gia = gia;
	}



	public Sach() {
		super();
	}



	public Sach(int nam, double gia) {
		super();
		this.nam = nam;
		this.gia = gia;
	}



	@Override
	public double Thanhtien(double gia, int nam) {
		// TODO Auto-generated method stub
		if (nam>2015) 
		{
			return gia*0.95;
		} else {
			return gia*0.85;
		}
	}

}
