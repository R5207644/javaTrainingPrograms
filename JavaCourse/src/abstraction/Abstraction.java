/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package abstraction;

/**
 *
 * @author local user
 */
public class Abstraction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Abclass 
        
        Simple simple = new Simple();
        System.out.println("factorial(7): " + simple.factorial(7));
        System.out.println("cube(6): " + simple.cube(6));
        simple.msg();
    }
    
}
