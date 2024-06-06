// WAP to convert decimal number to octal using array
import java.util.Scanner;
public class DecimalToOctal {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] oct = new int[100];
    int decimal;
    
    System.out.print("enter number = ");
    decimal = sc.nextInt();
    System.out.println();
    
    int i = 0;
    while(decimal > 0) {
      oct[i] = decimal % 8;
      decimal = decimal / 8;
      i++;
    }
    
    System.out.print("Your Number in Octal = ");
    for(int j = i-1; j>=0; j--) {
      System.out.print(oct[j]);
    }
    System.out.println();
    sc.close();
  }
}
