// WAP to convert decimal number to hexadecimal using array
import java.util.Scanner;
public class DecimalToHexadecimal {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] hex = new int[100];
    int decimal;
    
    System.out.print("enter number = ");
    decimal = sc.nextInt();
    System.out.println();
    
    int i = 0;
    while(decimal > 0) {
      hex[i] = decimal % 16;
      decimal = decimal / 16;
      i++;
    }
    
    System.out.println("Your Number in Hexadecimal = ");
    for(int j = i-1; j>=0; j--) {
      if(hex[j] >= 10) {
        System.out.print((char)(hex[j] + 55));
      } else {
        System.out.print(hex[j]);
      }
    }
    System.out.println();
    sc.close();
  }
}
