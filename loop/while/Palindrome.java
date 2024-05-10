// WAP to check palindrome

import java.util.Scanner;

public class Palindrome {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int num, rev = 0, temp;;

    System.out.print("Enter number = ");
    num = sc.nextInt();
    System.out.println();

    temp = num;

    while(num > 0) {
      rev = ( rev*10 ) + ( num % 10 );
      num = num / 10;
    }
    if(temp == rev) {
      System.out.print("Palindrome !!");
    } else {
      System.out.println("not palindome");
    }
    sc.close();
  }
} 