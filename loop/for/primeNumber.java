//WAP to check prime number using for loop

import java.util.Scanner;

public class primeNumber {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n, temp = 0;

    System.out.print("enter your number = ");
    n = sc.nextInt();
    System.out.println();

    for(int i = 2; i<n ; i++) {
      if(n % i == 0) {
        temp++;
      }
    }
    
    if(temp>0) {
      System.out.println("not prime !!");
    } else {
        System.out.println("prime !!");
      }
    sc.close();
  }
}