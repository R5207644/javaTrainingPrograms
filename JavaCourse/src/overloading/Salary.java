/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package overloading;

/**
 *
 * @author local user
 */
public class Salary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // object making
        
        // for manager
        
        Manager manager = new Manager("Sarvesh", "manager");
        manager.getDetails();
        System.out.println("salary = " + manager.calculateSalary());
        
        // for programmer
        
        Programmer programmer = new Programmer("AnuPriya", "programmer");
        programmer.getDetails();
        System.out.println("salary = " + programmer.calculateSalary());
    }
    
}
