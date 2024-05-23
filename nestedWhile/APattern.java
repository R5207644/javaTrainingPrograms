// WAP to print A Pattern using nested while

import java.util.Scanner;

public class APattern {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, i = 1, j;
    
    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();
    
    j = n;
    
    while(i <= n) {
      while(j >= i) {
        System.out.print(" ");
        j--;
      }
      j = 1;
      while(j <= i ) {
        if(j == 1 || i == n/2){
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
        j++;
      }
      j = 1;
      while(j < i) {
        if(j == i-1 || i == n/2) {
        System.out.print("*");
        } else {
          System.out.print(" ");
        }
        j++;
      }
      
      j = n;
      i++;
      System.out.println();
    }
  }
}
