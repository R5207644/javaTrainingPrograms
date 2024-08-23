/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package abstraction;

abstract class Abclass1 {
    public abstract void table(int x);
    public abstract void show();
}

abstract class Abclass2 extends Abclass1 {
    public abstract double circle(int radius);
    public abstract void display();
}

class MyDemoClass extends Abclass2 {
    
    public void table(int x) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(x * i);
        }
    }
    
    public void show() {
        System.out.println("Good Morning have Glorious day!!");
    }
    
    public double circle(int radius) {
        return 3.14 * radius * radius;
    }
    
    public void display() {
        System.out.println("Good Night have sweet dreams!!");
    }
    
}


public class AbstractInheritence {
    
    public static void main(String[] args) {
        //main program run from here
        
        MyDemoClass demo = new MyDemoClass();
        demo.table(7);
        demo.show();
        System.out.println("Area: " + demo.circle(7));
        demo.display();
    }
    
}
