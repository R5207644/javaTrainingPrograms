// WAP to convert character to number and vice versa

import java.util.Scanner;

public class ordinalValue {
  
  public static void ord() {

    Scanner sc = new Scanner(System.in);
    char character;
    
    System.out.print("Enter character = ");
    character = sc.next().charAt(0);
    System.out.println();
    System.out.println("value = " + (int)character);
    sc.close();
  }

  public static void character() {
    Scanner sc = new Scanner(System.in);
    int number;
    
    System.out.print("Enter number = ");
    number = sc.nextInt();
    System.out.println();
    System.out.println("value = " + (char)number);
    sc.close();
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int ch;
    
    System.out.print("Enter 1. for char to number  2 for num to char = ");
    ch = sc.nextInt();
    System.out.println();
    
    if(ch == 1) {
      ord();
    } else {
             character();
           }
    sc.close();
  }

}