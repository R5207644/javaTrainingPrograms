/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package overloading;

/**
 *
 * @author local user
 */
// Example class

class Example {
    final int num = 100;
    
    void data() {
//        num = 400;
        System.out.println("num: " + num);
    }
}


public class FinalClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Object
        
        Example obj = new Example();
        obj.data();
    }
    
}
