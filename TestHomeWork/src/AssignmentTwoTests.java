
public class AssignmentTwoTests {
	public static void main(String[] args)
	{
		System.out.println(" OnlineStore class");
		testQuestionOne();
		System.out.println(" GeometryTools class");
		testQuestionTwo();
		System.out.println(" OK ");
	}
	
	public static void testQuestionOne()
	{
		int[] validCard1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 0 };
		int[] invalidCard1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] invalidCard2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4 };

		System.out.println("Testing credit card validation.....");
		checkValidCard(validCard1);
		checkInvalidCard(invalidCard1);
		checkInvalidCard(invalidCard2);
		
		String validIsbn1 = "0345789674";
		String invalidIsbn1 = "034690756X";
		String invalidIsbn2 = "0340678567x";
		String invalidIsbn3 = "05903X";

		System.out.println("Testing ISBN validation.......");
		checkValidIsbn(validIsbn1);
		checkInvalidIsbn(invalidIsbn1);
		checkInvalidIsbn(invalidIsbn2);
		checkInvalidIsbn(invalidIsbn3);
	}
	
	public static void testQuestionTwo()
	{
		double px = 3.0;
		double py = 2.5;
		
		double radius = 2.0 + GeometryTools.EPSILON;
		
		double circleX1 = 4.0;
		double circleY1 = 3.5;
		
		double circleX2 = 5.0;
		double circleY2 = 3.0;
		
		System.out.println("Checking circle method....");
		if (!GeometryTools.detectInCircle(px, py, circleX1, circleY1, radius))
		{
			System.out.println("FAIL:  The point (" + px + "," + py + ") was found to be outside a circle centered at (" + circleX1 + "," + circleY1 +") with radius of " + radius);
		}
		else
		{
			System.out.println("PASS");
		}	
		
		if (GeometryTools.detectInCircle(px, py, circleX2, circleY2, radius))
		{
			System.out.println("FAIL:  The point (" + px + "," + py + ") was found to be inside a circle centered at (" + circleX2 + "," + circleY2 +") with radius of " + radius);
		}
		else
		{
			System.out.println("PASS");
		}	
		
		System.out.println("Testing point in convex polgon");
		System.out.println("Testing on a polygon with points: (0,0), (1,1), (1,2.5),(.5,3.5),(-.5,1.5)");
		
		double[] xCoords = {0, 1, 1,   0.5, -.5};
		double[] yCoords = {0, 1, 2.5, 3.5, 1.5};

		double px1 = .2; 
		double py1 = .3; 
		
		if (!GeometryTools.detectInPolygon(px1, py1, xCoords, yCoords))
		{
			System.out.println("FAIL:  The point (" + px1 + "," + py1 + ") was found to be outside the polygon.");
		}
		else
		{
			System.out.println("PASS");
		}	
		
		double px2 = .4; 
		double py2 = .3; 
		
		if (GeometryTools.detectInPolygon(px2, py2, xCoords, yCoords))
		{
			System.out.println("FAIL:  The point (" + px2 + "," + py2 + ") was found to be inside the polygon.");
		}
		else
		{
			System.out.println("PASS");
		}	
	}
	
	public static void checkValidIsbn(String validIsbn)
	{
		if (!OnlineStore.validateIsbn(validIsbn))
		{
			System.out.println("FAIL:  isbn validation failed on valid isbn: " + validIsbn);
		}
		else
		{
			System.out.println("PASS");
		}		
	}
	
	public static void checkInvalidIsbn(String invalidIsbn)
	{
		if (OnlineStore.validateIsbn(invalidIsbn))
		{
			System.out.println("FAIL:  isbn validation succeeded on invalid isbn: " + invalidIsbn);
		}
		else
		{
			System.out.println("PASS");
		}		
	}
	
	public static void checkValidCard(int[] validCard)
	{
		if (!OnlineStore.validateCreditCard(validCard))
		{
			System.out.println("FAIL: card validation failed on valid card: " + getArrayString(validCard));
		}
		else
		{
			System.out.println("PASS");
		}	
	}
	
	public static void checkInvalidCard(int[] invalidCard)
	{
		if (OnlineStore.validateCreditCard(invalidCard))
		{
			System.out.println("FAIL: card validation succeeded on invalid card: " + getArrayString(invalidCard));
		}
		else
		{
			System.out.println("PASS");
		}	
	}
	
	public static String getArrayString(int[] array)
	{
		String base = "";
		
		for (int i = 0; i < array.length; i++)
		{
			base += array[i] + " ";
		}
		
		return base;
	}
}
