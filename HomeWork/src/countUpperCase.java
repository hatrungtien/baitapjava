
public class countUpperCase {
	
	public void main(String args[] ) {
		String string = "12345rtff5&*%$I((";
		int upper =0;
		for (int i =0;i< string.length();i++) {
			char tit = string.charAt(i);
			if (tit>='A'&& tit<='z')
				upper++;
			else  
				System.out.print("....");
		
		}
		
		System.out.println("Upper case letters : " + upper);
}
}
