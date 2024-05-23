//WAP of fabnocci series using while loop

import java.util.Scanner;

public class FabnocciSeries{
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int a = 0, b = 1, c=0, n;

    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();

    System.out.print(a + " " +b +" ");

    while(c < n) {
      c = a + b;
      System.out.print(c +" ");
      
      //swaping a and b
      a = b;
      b = c;
    }
    sc.close();
  }
}