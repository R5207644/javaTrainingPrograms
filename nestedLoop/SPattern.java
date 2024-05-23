// WAP to print home pattern using nested Loop

import java.util.Scanner;

public class SPattern {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, i, j;
    
    System.out.print("enter n = ");
    n = sc.nextInt();
    System.out.println();
    
    for(i = 1; i <= n; i++) {
      for(j = 1; j <= n; j++) {
        if(i == 1 || i == n/2 || i == n) {
          System.out.print("*");
        } else if(i <= n/2) {
          if(j == 1) {
           System.out.print("*");
          } else {
            System.out.print(" ");
          }
        } else if(i > n/2) {
          if(j == n) {
           System.out.print("*");
          } else {
            System.out.print(" ");
          }
        }
      }
      System.out.println();
    }
    sc.close();
  }
}
