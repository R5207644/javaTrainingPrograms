//WAP to find hcf using for loop

import java.util.Scanner;

public class hcf {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int hcf = 1, a, b, n;

    System.out.print("Enter first number = ");
    a = sc.nextInt();
    System.out.println();

    System.out.print("Enter second number = ");
    b = sc.nextInt();
    System.out.println();

    if(a < b) {
      n = a;
    } else {
        n = b;
      }
  
    for(int i = 1; i <=n; i++) {
      if(a % i == 0 && b % i == 0) {
        hcf = i;
      }
    }
    
    System.out.println("HCF = " +hcf);
    sc.close();

  }
}