/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkginterface;

/**
 *
 * @author local user
 */
interface myInt {

    public void display();

    public int sum(int a, int b);
}

class Dummy implements myInt {

    public void display() {
        System.out.println("Good Morning");
    }

    public int sum(int a, int b) {
        return a + b;
    }
}
