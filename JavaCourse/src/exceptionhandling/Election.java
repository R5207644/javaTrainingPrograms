
package exceptionhandling;
import java.util.Scanner;

public class Election {
    
    static void validate(int age) throws Exception{
        
        if (age >= 18) {
            System.out.println("valid age");
        } else {
            throw new Exception("Age must be greater than or equals 18");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Age: ");
        int age = sc.nextInt();
        
        try {
            validate(age);
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
}
