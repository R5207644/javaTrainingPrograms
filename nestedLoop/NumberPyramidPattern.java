// WAP to print number pyramid pattern 

import java.util.Scanner;

public class NumberPyramidPattern {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int i, j, n;
    
    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();
    
    for(i = 1; i<=n; i++) {
    
      for(j=n; j>=i; j--)
      {
        System.out.print(" ");
      }
      
      for(j = 1; j<=i; j++) {
            System.out.print(j);
      }
      
      for(j=1; j<i; j++) {
        System.out.print(i-j);
      }
      
      System.out.println();
      
    }
    sc.close();
  }
}
