//WAP to print pattern where row and column number using do while loop

import java.util.Scanner;

public class PositionalNumberPattern {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int i, j, n;
    
    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();
    
    i = 0; j = 0;
    do {
      do {
        if(i == j) {
          System.out.print(i+ " ");
        } else {
          System.out.print("0 ");
        }
        
        j++;
      } while(j<=n);
      
      System.out.println();
      i++;
      j = 0;
    } while(i<=n);
    sc.close();
  }
}
