// WAP to print n natural number using for loop

import java.util.Scanner;

public class factorial {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n, fact = 1;

    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();

    for(int i=n; i>=1; i--) {
      fact = fact*i;
      if(i == 1) {
        System.out.print(i);
        break;
      }
      System.out.print(i +" * ");
    }
    System.out.println(" = " +fact);
    sc.close();
  }
}