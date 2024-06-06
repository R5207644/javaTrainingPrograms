// WAP to input and print values of a array 

import java.util.Scanner;
public class FirstArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numbers = new int[10];
    
    System.out.println("Enter Array = ");
    for(int i = 0; i < 10; i++) {
      numbers[i] = sc.nextInt();
    }
    
    System.out.println("Your Array is = ");
    for(int i = 0; i < 10; i++) {
      System.out.print(numbers[i] + " ");
    }
    sc.close();
  }
}
