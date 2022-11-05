package GLuong;

import java.util.Scanner;

public class Test {

	public void doUpdate() {
		XLLuong xlLuong = new XLLuong();
		Nhanvien nv = new Nhanvien();
		Scanner input = new Scanner(System.in);
		System.out.println("Input ID: ");
		String ma = input.next();
		nv = xlLuong.getNVbyMa(ma);
		System.out.println(nv);
		System.out.println("Input new name: ");
		String name = input.next();
		System.out.println("1.Hải Phòng");
		System.out.println("2.Hà Nội");
		System.out.println("3.Nam Định");
		System.out.println("Input new Address: ");
		int address = input.nextInt();
		String a = new String();
		switch (address) {
        case 1:
            a = "Hải Phòng";
            break;
        case 2:
        	a = "Hà Nội";
            break;
        case 3:
            a = "Nam Định";
            break;
		}
		System.out.println("Input new Salary: ");
		double salary = input.nextDouble();
		input.close();
		nv = new Nhanvien(ma, name, a, salary);
		if(xlLuong.updateNV(nv)) {
			System.out.println("Update success");
		}
		else {
			System.out.println("Update failure");
		}
		System.out.println(nv);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();
		test.doUpdate();
	}

}
