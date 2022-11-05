package GDiem;
import java.util.*;
public class TestHocvien {

	public void doinsert(Hocvien hv) {
		XLDiem xl = new XLDiem();
		if(xl.insertHV(hv)==true)
			System.out.println("Them thanh cong");
		else {
			System.out.println("Them that bai");
		}
	}
	
	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in)) {
			System.out.println("Nhap Ma: ");
			int ma = input.nextInt();
			System.out.println("Nhap Ten: ");
			String ten = input.next();
			System.out.println("Nhap Lop: ");
			String lop = input.next();
			System.out.println("Nhap Diem: ");
			double diem = input.nextDouble();
			Hocvien hv = new Hocvien(ma, ten, lop, diem);
			TestHocvien aHocvien = new TestHocvien();
			aHocvien.doinsert(hv);
		}
	}

}
