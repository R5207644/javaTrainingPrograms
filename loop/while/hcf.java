//WAP to find hcf using while loop

import java.util.Scanner;

public class hcf {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int a, b, n = 0, i = 2, hcf = 1;

    System.out.print("Enter a = ");
    a = sc.nextInt();
    System.out.println();

    System.out.print("Enter b = ");
    b = sc.nextInt();
    System.out.println();

    if(a < b) {
      n = a;
    } else {
        n = b;
    }
    
    while(i <= n) {
      if(a % i == 0 && b % i == 0) {
        hcf = i;
      }
      i++;
    }
    if(hcf > 0) {
      System.out.println("hcf = " +hcf);
    } else {
        System.out.println("Co-Prime numbers ");
    }
    sc.close();
  }
}