// WAP to print series that have every element double to its previous element

import java.util.Scanner;

public class Series {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, i = 1;
    
    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();
    sc.close();
    
    do {
      System.out.print(i * 2 +" ");
      i = i * 2;
    } while(i <= n);
  }
}
