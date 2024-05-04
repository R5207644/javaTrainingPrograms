// 2. WAP tp convert dollar into rupees

import java.util.Scanner;
public class currencyConverter {
	public static void main( String args[] ) {

		Scanner sc = new Scanner(System.in);
		
		float dollar, rupees;

		System.out.print("enter ammount in dollar = " + "\n");
		dollar = sc.nextFloat();
		
		rupees = dollar * 83.2345f;

		System.out.print("In Rupee = " + rupees);
		sc.close();
		
		}
}