
package exceptionhandling;
import java.util.Scanner;

public class Dummy {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            
            int a, b, c;
            try {
                
                System.out.println("enter two numbers: ");
                a = sc.nextInt();
                b = sc.nextInt();
                
                c = a / b;
                System.out.println("result: " + c);
                
            } catch (Exception ex) {
                
                System.out.println(ex);
                
            } finally {
                System.out.println("Thank You for using my App !!");
            }
            
        }
    }
    
}
