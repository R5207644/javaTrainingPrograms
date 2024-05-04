// WAP to calculate bill based on unit ( simple if else program)

import java.util.Scanner;
public class electricityBill {

  public static void main(String args[]) {
  
    Scanner sc = new Scanner(System.in);
    
    int unit;
    float bill = 0, surcharge = 0;

    System.out.print("Enter yout unit = ");
    unit = sc.nextInt();
    System.out.println();

    if(unit < 100) {

      bill = unit * 4.25f;

    } else if(unit <= 200) {

        bill = unit * 4.75f;

      } else if(unit <= 400) {

          bill = unit * 5.25f;

        } else if(unit <= 600) {

            bill = unit * 5.85f;

          } else {

              bill = unit * 6.0f;

            }

    if(bill > 1500) {
      surcharge = (bill * 20)/100;
    }

    System.out.println("Your net bill is = " +bill +" and surcharge is = " +surcharge +" so gross bill is = " +(bill+surcharge) );
    sc.close();
  }
}