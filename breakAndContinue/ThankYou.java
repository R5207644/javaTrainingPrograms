// WAP to print number upto n and print thank you when number is divisible by 11

import java.util.Scanner;

public class ThankYou {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n, i=0;

    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();

    while(i <= n) {
      if(i % 11 == 0) {
        System.out.println("Thank You");
        i++;
        continue;
      }
      System.out.println(i);
      i++;
    }
    sc.close();
  }
}