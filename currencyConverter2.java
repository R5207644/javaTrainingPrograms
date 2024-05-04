// 5. WAP to convert rupee into dollar in notepad

import java.util.Scanner;
public class currencyConverter2 {
	public static void main( String args[] ) {

		Scanner sc = new Scanner(System.in);
		
		float dollar, rupees;

		System.out.print("enter ammount in rupees = " + "\n");
		rupees = sc.nextFloat();
		
		dollar = rupees / 83.2345f;

		System.out.print("In Rupee = " + dollar);
		sc.close();
		}
}