// WAP to print Swastic pattern using nested for loop

import java.util.Scanner;

public class SwasticPattern {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int i, j, n;

    System.out.print("enter n = ");
    n = sc.nextInt();
    System.out.println();

    for(i = 1; i <= n; i++) {
      for(j = 1; j<=n; j++) {
        if(i == 1) {
          if(j >= n/2 || j == 1) {
            System.out.print("* ");
          } else {
                  System.out.print("  ");
                }
        } else if(i < n/2 ) {
            if(j == 1 || j == n/2) {
              System.out.print("* ");
            } else {
                  System.out.print("  ");
                }
          } else if(i == n/2) {
              System.out.print("* ");
            } else if(i == n) {
                if(j <= n/2 || j == n) {
                  System.out.print("* ");
                } else {
                  System.out.print("  ");
                }
              } else if(i > n/2) {
                if(j == n || j == n/2) {
                  System.out.print("* ");
                } else {
                  System.out.print("  ");
                }
              }
      }
      System.out.println();
    }
    sc.close();
  }
}
