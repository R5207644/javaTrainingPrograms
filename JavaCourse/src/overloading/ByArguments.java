/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package overloading;

/**
 *
 * @author local user
 */
public class ByArguments {
    // when passing one argument
    
    public float area(float r) {
        return 3.14f * r * r;
    }
    
    // when passing two argument area of rectangle
    
    public float area(float l, float b) {
        return 2 * (l + b);
    }
    
    // when passing three argument, area of triangle
    
    public float area(float a, float b, float c) {
        float s = (a + b + c) / 2;
        return (float)Math.sqrt(s * (s -a) * (s - b) * (s - c));
    }
}
