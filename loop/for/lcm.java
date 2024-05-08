//WAP to find lcm using for loop

import java.util.Scanner;

public class lcm {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int lcm = 0, a, b, n = 0;

    System.out.print("Enter first number = ");
    a = sc.nextInt();
    System.out.println();

    System.out.print("Enter second number = ");
    b = sc.nextInt();
    System.out.println();

    if(a > b) {
      n = a;
    } else {
        n = b;
      }
  
    for(int i = (a * b); i >= n; i--) {
      if(i % a == 0 && i % b == 0) {
        lcm = i;
      }
    }
    
    System.out.println("lcm = " +lcm);
    sc.close();

  }
}