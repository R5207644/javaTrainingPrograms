//WAP to find LCM using while loop

import java.util.Scanner;

public class LCM {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int a, b, lcm = 0, n;

    System.out.print("Enter a = ");
    a = sc.nextInt();
    System.out.println();

    System.out.print("Enter b = ");
    b = sc.nextInt();
    System.out.println();

    if(a > b) {
      n = a;
    } else {
        n = b;
    }
    
    int i = a * b;

    while(i >= n) {
      if(i % a == 0 && i % b == 0) {
        lcm = i;
      }
      i--;
    }

    System.out.println("lcm = " +lcm);
    sc.close();

  }
}