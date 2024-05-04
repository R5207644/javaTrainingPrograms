// 3. WAP to convert seconds into standard time format hh mm ss in notepad

import java.util.Scanner;
public class timeConvert{
	public static void main(String args[]) {
		int sec, minute, hour, givenTime;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter time in second = ");
		givenTime = sc.nextInt();

		hour = givenTime / (60 * 60);
		minute = (givenTime % (60 * 60)) / 60;
		sec = (givenTime % (60 * 60)) % 60 ;

		System.out.print("converted time is " + hour + "hour " + minute +"minute " + sec + "second");
		sc.close();
	}	
}