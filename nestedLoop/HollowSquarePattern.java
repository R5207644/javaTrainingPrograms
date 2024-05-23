// WAP to print hollow square pattern using nested for loop

import java.util.Scanner;

public class HollowSquarePattern {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int i, j, n;

    System.out.print("enter n = ");
    n = sc.nextInt();
    System.out.println();

    for(i = 1; i <= n; i++) {
      for(j = 1; j<=n; j++) {
        if(i == 1 || i == n) {
          System.out.print("*");
        } else {
            if(j == 1 || j == n) {
              System.out.print("*");
            } else {
                System.out.print(" ");
              }
          }
      }
      System.out.println();
    }
  }
}