// WAP to convert decimal number to binary using array
import java.util.Scanner;
public class DecimalToBinary {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] bin = new int[100];
    int decimal;
    
    System.out.print("enter number = ");
    decimal = sc.nextInt();
    System.out.println();
    
    int i = 0;
    while(decimal > 0) {
      bin[i] = decimal % 2;
      decimal = decimal / 2;
      i++;
    }
    
    System.out.println("Your Number in binary");
    for(int j = i-1; j>=0; j--) {
      System.out.print(bin[j]);
    }
    System.out.println();
    sc.close();
  }
}
