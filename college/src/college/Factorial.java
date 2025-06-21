
package college;
import java.util.Scanner;

/**
 *
 * @author Sarvesh Kumar
 */
public class Factorial {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number: ");
        int n = sc.nextInt();
        System.out.println();
        
        int result = fact(n);
        System.out.println("Result: " + result);
    }
    public static int fact(int n) {
        if (n >2 ) {
           n = n * fact(n-1); 
        } else {
           return n * (n - 1); 
        }
        return n;
    }
    
}
