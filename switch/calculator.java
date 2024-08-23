// WAP of calculator to calculate two numbers using switch case

import java.util.Scanner;

class calculator {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int a, b;
    char operator;

    System.out.print("Enter a = ");
    a = sc.nextInt();
    System.out.println();

    System.out.print("Enter operator = ");
    operator = sc.next().charAt(0);
    System.out.println();

    System.out.print("Enter b = ");
    b = sc.nextInt();
    System.out.println();

    switch(operator) {
      case '+':
        System.out.println("sum = " +( a+b ));
        break;
      case '-':
        System.out.println("difference = " +( a-b ));
        break;
      case '*':
        System.out.println("multiple = " +( a*b ));
        break;
      case '/':
        System.out.println("divident = " +( a/b ));
        break;
      case '%':
        System.out.println("remainder = " +( a%b ));
        break;
      default:
        System.out.println("wrong option !!");

    }
    sc.close();
  }
}