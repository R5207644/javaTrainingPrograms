//WAP to find fizz and buzz with help of for loop

import java.util.Scanner;

public class fizzBuzz {

  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    int n;

    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();

    for(int i = 0; i<=n; i++) {
      if(i % 3 == 0 && i % 5 == 0) {
        System.out.println("FIZZ BUZZ");
      } else if(i % 5 == 0) {
          System.out.println("BUZZ");
      } else if(i % 3 == 0) {
          System.out.println("FIZZ");
      } else {
          System.out.println(i);
      }
    }
    sc.close();
  }
}