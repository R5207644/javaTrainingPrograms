/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkginterface;

/**
 *
 * @author local user
 */
interface myInt1 {

    public int cube(int n);
    
    public int rectangle(int a, int b);
}

interface myInt2 {

    public int fact(int n);
}

class Dummy1 implements myInt1, myInt2 {
    
    @Override
    public int cube(int n) {
        return n * n * n;
    }
    
    @Override
    public int rectangle(int a, int b) {
        return a * b;
    }
    
    @Override
    public int fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        
        return fact;
    }
    
}

public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Dummy1 dummy = new Dummy1();
        System.out.println("cube: " + dummy.cube(7));
        System.out.println("area: " + dummy.rectangle(10, 12));
        System.out.println("factorial: " + dummy.fact(5));
    }
    
}
