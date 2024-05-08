// WAP to print n natural number using for loop

import java.util.Scanner;

public class naturalNumber {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n, sum = 0;

    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();

    for(int i=1; i<=n; i++) {
      sum += i;
      if(i == n) {
        System.out.print(i);
        break;
      }
      System.out.print(i +" + ");
    }
    System.out.println(" = " +sum);
    sc.close();
  }
}