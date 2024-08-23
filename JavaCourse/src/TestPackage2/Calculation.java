/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TestPackage2;
import java.util.Scanner;

/**
 *
 * @author local user
 */
public class Calculation {

    public static int divide(int a, int b) {
        int c = a / b;
        return c;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Number: ");
        int a = sc.nextInt();
        System.out.println();
        
        System.out.println("Enter divisor: ");
        int b = sc.nextInt();
        System.out.println();
        
        System.out.println("c = " + divide(a, b));
    }
    
}
