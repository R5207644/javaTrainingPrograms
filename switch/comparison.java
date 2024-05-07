//WAP of comparison of two numbers using switch statement

import java.util.Scanner;

public class comparison{

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int a, b;

    System.out.print("Enter a = ");
    a = sc.nextInt();
    System.out.println();
    
    System.out.print("Enter b = ");
    b = sc.nextInt();
    System.out.println();

    int opt = a>b? 1: 0;

    switch(opt) {
      case 1:
        System.out.println("a is greater !!");
        break;
      case 0:
        opt = a==b?1: 0;
        switch(opt) {
          case 1:
            System.out.println("a and b are equal ");
            break;
          case 0:
            System.out.println("b is greater !!");
            break;
        }
        break;
    }
  }
}