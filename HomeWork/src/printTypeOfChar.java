import java.util.Scanner;

public class printTypeOfChar {
	static void test(char tit) {
		if (tit >= 'A' && tit <= 'Z')
			System.out.println(" "+tit + " UpperCase character ");
		else if (tit >= 'a' && tit <= 'z')
			System.out.println(" " + tit + " LowerCase ");

		else
			System.out.println(" " + tit + " SYMBOl ");
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Input: ");
		char tit = reader.next().charAt(0);
		test(tit);
		reader.close();
	}
}
