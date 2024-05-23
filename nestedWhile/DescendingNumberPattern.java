//WAP to print number pyramid using do while loop

import java.util.Scanner;

public class DescendingNumberPattern {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int i, j, n;
    
    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();
    
    i = 0; j = 0;
    do {
      do {
        if(j <= n/2 && j >= n/2-i) {
          System.out.print(j);
        } else if(j > n/2 && j <= n/2 + i) {
          System.out.print(n/2 - (j - n/2));
        }
        else { 
          System.out.print(" ");
        }
        
        j++;
      } while(j<=n);
      
      System.out.println();
      i++;
      j = 0;
    } while(i<n/2);
    sc.close();
  }
}
