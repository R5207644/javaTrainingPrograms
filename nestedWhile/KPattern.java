// WAP to print K Pattern using while loop

import java.util.Scanner;

public class KPattern {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, i=1, j=1;
    
    System.out.print("enter n = ");
    n = sc.nextInt();
    System.out.println();
    
    while(i <= n*2-1) {
      while(j <= n) {
        if(j == 1) {
          System.out.print("*");
        } else if(i <=n) {
          if(j == n-i+1) {
            System.out.print("*");
          } else {
            System.out.print(" ");
          }
        } else if(i > n) {
          if(j == (i-n) +1 ) {
            System.out.print("*");
          } else {
            System.out.print(" ");
          }
        }
        j++;
      }
      i++;
      j = 1;
      System.out.println();
    }
    sc.close();
  }
}
