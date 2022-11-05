package GKH;

public class Khachhang {
	 private char SoTK;
	 private char Hoten;
	 private char GT;
	 private char Diachi;
	 private char Sodu;
	public Khachhang(char soTK, char hoten, char gT, char diachi, char sodu) {
		SoTK = soTK;
		Hoten = hoten;
		GT = gT;
		Diachi = diachi;
		Sodu = sodu;
	}
	public char getSoTK() {
		return SoTK;
	}
	public void setSoTK(char soTK) {
		SoTK = soTK;
	}
	public char getHoten() {
		return Hoten;
	}
	public void setHoten(char hoten) {
		Hoten = hoten;
	}
	public char getGT() {
		return GT;
	}
	public void setGT(char gT) {
		GT = gT;
	}
	public char getDiachi() {
		return Diachi;
	}
	public void setDiachi(char diachi) {
		Diachi = diachi;
	}
	public char getSodu() {
		return Sodu;
	}
	public void setSodu(char sodu) {
		Sodu = sodu;
	}
	 
	 
	
}

