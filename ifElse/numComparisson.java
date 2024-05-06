// WAP to check wich number is greater using nested if else

import java.util.Scanner;

public class numComparisson {

  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    int num1, num2, num3;

    System.out.print("Enter First number = ");
    num1 = sc.nextInt();
    System.out.println();

    System.out.print("Enter Second number = ");
    num2 = sc.nextInt();
    System.out.println();

    System.out.print("Enter Third Number = ");
    num3 = sc.nextInt();
    System.out.println();

    if(num1 > num2) {
      if(num1 > num3) {
        System.out.println("first number ( " + num1 + ") is greater !");
      } else {
          System.out.println("Third number is greater = " + num3);
        }
    } else {
        if(num2 > num3) {
          System.out.println("number 2nd is greater = " +num2);
        } else {
            if(num3 > num2) {
              System.out.println("Third number is greater = " + num3);
            } else {
                System.out.println(" all are equal !!");
              }
          }
      }
    sc.close();
  }
}