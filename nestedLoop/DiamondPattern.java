// WAP to print diamond pattern using nested Loop

import java.util.Scanner;

public class DiamondPattern {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, i, j, k;
    
    System.out.print("enter n = ");
    n = sc.nextInt();
    System.out.println();
    
    for(i = 1; i<=n; i++){
      for(j = i; j< n; j++) {
      System.out.print(" ");
      }
      
      for(k = 1; k <= (2*i-1); k++ ) {
        System.out.print("*");
      }
      System.out.println();
    }
    
    for(i = n-1; i>=1; i--){
      for(j = n; j >i; j--) {
      System.out.print(" ");
      }
      
      for(k = 1; k <= (2*i - 1); k++ ) {
        System.out.print("*");
      }
      System.out.println();
    }
    sc.close();
  }
}
