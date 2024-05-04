// WAP to convert currency based on user choice 

import java.util.Scanner;
public class currencyConverter {
  
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    int ch;
    float rupee, dollar;

    System.out.print("Enter 1. for dollar to INR and " + "\n" + "2. for INR to dollar = ");
    ch = sc.nextInt();
    System.out.println();

    if(ch == 1) {

      System.out.print("Enter currency in dollar = ");
      dollar = sc.nextFloat();
      System.out.println();

      rupee = dollar * 83.232f;
      System.out.print("value in rupee = " + rupee);
        }
    
    else if(ch == 2) {

      System.out.print("Enter currency in rupee = ");
      rupee = sc.nextFloat();
      System.out.println();

      dollar = rupee / 83.232f;
      System.out.print("value in dollar = " + dollar);
        }

    else {
      System.out.print("wrong choice ");
      }

    sc.close();
    }

}