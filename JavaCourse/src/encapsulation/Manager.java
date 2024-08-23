/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package encapsulation;

/**
 *
 * @author local user
 */
public class Manager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.setEmpId(1);
        bank.setName("Sarvesh");
        bank.setGender("male");
        bank.setSalary(120000.0f);
        bank.setAddress("Varansi");
        
        System.out.println("emp Id = " + bank.getEmpId());
        System.out.println("Name = " + bank.getName());
        System.out.println("Gender = " + bank.getGender());
        System.out.println("Salary = " + bank.getSalary());
        System.out.println("Address = " + bank.getAddress());
        
    }
    
}
