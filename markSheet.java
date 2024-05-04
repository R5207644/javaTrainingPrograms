// 4. WAP to calculate sum of marks and percentage of marks in notepad

import java.util.Scanner;
public class markSheet {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);

	int english, physics, chemistry, maths, python, sum = 0;
	float percentage;

	System.out.println("enter marks of english = ");
	english = sc.nextInt();

	System.out.println("enter marks of physics = ");
	physics = sc.nextInt();

	System.out.println("enter marks of chemistry = ");
	chemistry = sc.nextInt();

	System.out.println("enter marks of maths = ");
	maths = sc.nextInt();

	System.out.println("enter marks of python = ");
	python = sc.nextInt();

	sum = english +physics +chemistry +maths + python;

	percentage = sum/5.0f;
		
	System.out.println("sum = " + sum + " percentage = " + percentage);
	sc.close();
 	
	}	
}