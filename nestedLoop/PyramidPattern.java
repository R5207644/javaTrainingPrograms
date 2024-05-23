// WAP to print pyramid Star pattern using nested for loop

import java.util.Scanner;

public class PyramidPattern {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    
    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();
    
    for(int i = 1; i<=n; i++) {
    
      for(int j=n; j>=i; j--)
      {
        System.out.print(" ");
      }
      
      for(int j = 1; j<=i; j++) {
            System.out.print("*");
      }
      
      for(int j=1; j<i; j++) {
        System.out.print("*");
      }
      
      System.out.println();
      
    }
    sc.close();
  }
}
