// WAP to reverse a number using while loop

import java.util.Scanner;

public class Reverse {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int num, rev = 0;

    System.out.print("Enter number = ");
    num = sc.nextInt();
    System.out.println();

    while(num > 0) {
      rev = ( rev*10 ) + ( num % 10 );
      num = num / 10;
    }
    System.out.println("reverse = " +rev);
    sc.close();
  }
} 