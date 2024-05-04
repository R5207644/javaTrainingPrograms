// WAP simple program of currency converter to convert values into multiple currencies

import java.util.Scanner;
public class multiCurrencyConverter {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("*-! Currency Conveter !-*");

    int rupee, ch;
   
    System.out.print("Enter value in rupee = ");
    rupee = sc.nextInt();
    System.out.println();

    System.out.print("Enter \n 1. for dollar \n 2. for yen \n 3. for pound \n 4. for ruble \n Enter your choice = ");
    ch = sc.nextInt();
    System.out.println();

    if(ch == 1) {
      System.out.println("value in dollar = " + (rupee * 83.38f));
    } else if(ch == 2) {
        System.out.println("value in yen = " + (rupee * 0.5447f));
      } else if(ch == 3) {
          System.out.println("value in pound = " + (rupee * 104.6254f));
        } else if(ch == 4) {
            System.out.println("value in ruble = " + (rupee * 0.9115f));
          } else {
              System.out.println("wrong choice ");
            }
    sc.close();

  }
}