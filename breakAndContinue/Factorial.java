//WAP to find factorial using java

import java.util.Scanner;

public class Factorial {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int fact = 1, n;
    
    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();
    
    do {
      fact = fact * (n);
      if( n == 1) {
        System.out.print(n);
      } else {
        System.out.print(n +" * ");
        }
      n--;
    } while(n >= 1);
    
    System.out.print(" = " +fact);
    sc.close();
  }
}
