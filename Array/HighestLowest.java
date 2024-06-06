// WAP to print highest and lowest element of array 
import java.util.Scanner;
public class HighestLowest {
  public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int highest, lowest, secondHighest= 0;
  int[] numbersList = new int[10];
  
  System.out.println("enter your array = ");
  
  for(int i = 0; i < 10; i++) {
    numbersList[i] = sc.nextInt();
  }
  highest = numbersList[0];
  lowest = numbersList[0];
  for(int i = 0; i < 10; i++) {
    if(highest < numbersList[i]) {
      secondHighest = highest;
      highest = numbersList[i];
    }
    if(lowest > numbersList[i]) {
      lowest = numbersList[i];
    }
  }
  System.out.println("highest = "+highest + " lowest = "+lowest +" Second Highest = " +secondHighest);
  sc.close();
  }
}
