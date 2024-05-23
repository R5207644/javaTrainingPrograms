// WAP to print square Star pattern using nested for loop

import java.util.Scanner;

public class SquarePattern {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    
    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();
    
    for(int i = 1; i<=n; i++) {
      for(int j = 1; j<=n; j++) {
        System.out.print(" * ");
      }
      System.out.println();
    }
    sc.close();
  }
}
