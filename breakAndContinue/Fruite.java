//WAP to choose fav fruite

import java.util.Scanner;
public class Fruite {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int ch = 0, n = 1;
    
    while(n ==1) {
      System.out.println("Enter your favourite fruite =>");
      System.out.println("1. Banana ");
      System.out.println("2. Mango ");
      System.out.println("3. Guava ");
      System.out.println("4. Apple ");
      System.out.print("Enter Your Choice = ");
      ch = sc.nextInt();
      System.out.println();
      
      if(ch == 1) {
        System.out.println("Thank You ");
        break;
      }
    }
    sc.close();
  }
}
