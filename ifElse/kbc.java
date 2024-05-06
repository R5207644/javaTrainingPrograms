//WAP of KBC quiz show using nested if for continuation of game based on user choice

import java.util.Scanner;

public class kbc {
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    String nxt, ch;
    int prizeValue = 0;
    
    System.out.println("Q1. Which Indian actress played the lead role in the Hollywood movie “Quantico”?");
    System.out.println("A. Priyanka Chopra");
    System.out.println("B. Deepika Padukone");
    System.out.println("C. Kareena Kapoor");
    System.out.println("D. Alia Bhatt");
    System.out.println();
    System.out.print("Enter your choice = ");
    
    ch = sc.next();
    System.out.println();

    if(ch.equals("A") || ch.equals("a")) {
      prizeValue += 5000;
      System.out.print("correct ans, type yes if you want to continue = ");
      nxt = sc.next();
      
      if(nxt.equals("yes")) {
        System.out.println("Q1. How many states are there in India?");
        System.out.println("A. 25");
        System.out.println("B. 28");
        System.out.println("C. 30");
        System.out.println("D. 32");
        System.out.println();
        System.out.print("Enter your choice = ");
    
        ch = sc.next();
        System.out.println();

        if(ch.equals("B") || ch.equals("b")) {
          prizeValue += 5000;
          System.out.print("correct ans, type yes if you want to continue = ");
          nxt = sc.next();

          if(nxt.equals("yes")) {
          System.out.println("Q1. Where is India Gate located?");
          System.out.println("A. mumbai");
          System.out.println("B. kolkata");
          System.out.println("C. chennai");
          System.out.println("D. delhi");
          System.out.println();
          System.out.print("Enter your choice = ");
    
          ch = sc.next();
          System.out.println();
            if(ch.equals("D") || ch.equals("d")) {
              prizeValue += 5000;
              System.out.println("Correct ans, you won game !!");
            } else {
              System.out.println("wrong ans! ");
              }
          }
        } else {
          System.out.println("wrong ans !");
          }
      }
    } else {
        System.out.println("wrong ans !");
      }
    System.out.println("Welcome! you won prize money of " +prizeValue);
    sc.close();
  }
}