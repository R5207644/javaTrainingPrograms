// WAP to count no of odd and even elements in our array
import java.util.Scanner;
public class CountOddAndEven {
  public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int odd = 0, even = 0;
  int[] numbersList = new int[10];
  
  System.out.println("enter your array = ");
  
  for(int i = 0; i < 10; i++) {
    numbersList[i] = sc.nextInt();
  }
  for(int i = 0; i < 10; i++) {
    if(numbersList[i] % 2 == 0) {
      even++;
    } else {
      odd++;
    }
  }
  System.out.println("even = "+even + " odd = "+ odd);
  sc.close();
  }
}
