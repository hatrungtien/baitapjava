package Gui;


// ở đây nó se báo lỗi tại vì ông chưa overide nó lại...
//ở đây nó se báo lỗi tại vì ông chưa overide nó lại...
public class testInterface extends Abstract implements demo {

	@Override
	public void myMethod4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myMethod5() {
		// TODO Auto-generated method stub
		System.out.println("overide abstract");
		
	}
	public static void main(String[] args) {
		testInterface a = new testInterface();
		a.myMethod6();
		a.myMethod5(); // thang nay của abstract
		a.myMethod(); // thằng này của inter face
	}
	// khac nhau o cho do day... lớp abstract thì ông vẫn định code xử lý được hàm.. còn lớp interface thì ko
	
	@Override
	public void myMethod() {
		// TODO Auto-generated method stub
		System.out.println("overide interface");
	}

	@Override
	public void myMethod1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myMethod2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myMethod3() {
		// TODO Auto-generated method stub
		
	}

	// ông phải overide lại cả 4 cái thì nó mới ko bị lỗi..
	// lớp abstract nó cũng tương tương tự nhưng khác chỗ là có những hàm ông ko cần overide lại...

//	nếu bh ông kế thừa abstract thì ông chỉ việc overide lại 2 cái hàm abstract kía thôi  còn cái hàm methode6 kia ông vẫn dùng được bình thường
	
}
