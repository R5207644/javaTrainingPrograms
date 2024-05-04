// 1. WAP to calculate simple interest using java in notepad

import java.util.Scanner;
public class simpleInterest {
	public static void main(String args[]){
		int principle, rate, time, simpleInterest;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter principle ammount = " + "\n");
		principle = sc.nextInt();

		System.out.print("enter rate of interest = " + "\n");
		rate = sc.nextInt();

		System.out.print("enter time = " + "\n");
		time = sc.nextInt();


		simpleInterest = (principle* rate * time)/100;

		System.out.print("interest = " + simpleInterest);
		sc.close();
			
	}	
}