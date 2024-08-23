/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package overloading;

/**
 *
 * @author local user
 */
public class Employee {
    // Employee details using constructor
    
    String name;
    String role;
    
    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
    
    // getDetails function
    
    public void getDetails() {
        System.out.println("name: " + name + " role: " + role);
    }
    
    // calculateSalary method
    
    public double calculateSalary() {
        return 0;
    }
}

class Manager extends Employee {
    // constructor
    
    public Manager(String name, String role) {
        super(name, role);
    }
    // calculateSalary method of manager
    
    public double calculateSalary() {
        float baseSalary = 50000;
        float bonus = 5000;
        return baseSalary + bonus;
    }
}

// Programmer class

class Programmer extends Employee {
    // constructor
    
    public Programmer(String name, String role) {
        super(name, role);
    }
    
    // calculate salary method 
    
    public double calculateSalary() {
        float baseSalary = 25000;
        float bonus = 2500;
        return baseSalary + bonus;
    }
    
}
