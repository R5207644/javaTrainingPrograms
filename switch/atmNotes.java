//WAP of currency distribution using switch 

import java.util.Scanner;

public class atmNotes {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int ammount, notes;

    System.out.print("Enter ammount = ");
    ammount = sc.nextInt();
    System.out.println();
    System.out.print("Enter note choice = ");
    notes = sc.nextInt();
    System.out.println();

    switch(notes) {
      case 500:
        System.out.println("500 notes = " +(ammount/500));
        ammount = ammount%500;
        System.out.println("200 notes = " +(ammount/200));
        ammount = ammount%200;
        System.out.println("100 notes = " +(ammount/100));
        ammount = ammount%100;
        System.out.println("50 notes = " +(ammount/50));
        ammount = ammount%50;
        System.out.println("20 notes = " +(ammount/20));
        ammount = ammount%20;
        System.out.println("10 notes = " +(ammount/10));
        ammount = ammount%10;
        System.out.println("rest ammount = " +(ammount));
        break;
      case 200:
        System.out.println("200 notes = " +(ammount/200));
        ammount = ammount%200;
        System.out.println("100 notes = " +(ammount/100));
        ammount = ammount%100;
        System.out.println("50 notes = " +(ammount/50));
        ammount = ammount%50;
        System.out.println("20 notes = " +(ammount/20));
        ammount = ammount%20;
        System.out.println("10 notes = " +(ammount/10));
        ammount = ammount%10;
        System.out.println("rest ammount = " +(ammount));
        break;
      case 100:
        System.out.println("100 notes = " +(ammount/100));
        ammount = ammount%100;
        System.out.println("50 notes = " +(ammount/50));
        ammount = ammount%50;
        System.out.println("20 notes = " +(ammount/20));
        ammount = ammount%20;
        System.out.println("10 notes = " +(ammount/10));
        ammount = ammount%10;
        System.out.println("rest ammount = " +(ammount));
        break;
      case 50:
        System.out.println("50 notes = " +(ammount/50));
        ammount = ammount%50;
        System.out.println("20 notes = " +(ammount/20));
        ammount = ammount%20;
        System.out.println("10 notes = " +(ammount/10));
        ammount = ammount%10;
        System.out.println("rest ammount = " +(ammount));
        break;
      case 20:
        System.out.println("20 notes = " +(ammount/20));
        ammount = ammount%20;
        System.out.println("10 notes = " +(ammount/10));
        ammount = ammount%10;
        System.out.println("rest ammount = " +(ammount));
        break;
      case 10:
        System.out.println("10 notes = " +(ammount/10));
        ammount = ammount%10;
        System.out.println("rest ammount = " +(ammount));
        break;
    }
  }
}