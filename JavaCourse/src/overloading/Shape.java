package overloading;

public class Shape {
    // calculate area function
    
    public void calculateArea() {
        System.out.println("area of shape not possible with this function");
    }
}

// circle subclass

class Circle extends Shape {
    // passing values usingconstructor
    
    float radius;
    public Circle(float radius) {
    this.radius = radius;
    }
    // calculate area function in cicrcle
    
    public void calculateArea() {
        System.out.println("Area: " + 3.14f * radius * radius);
    }
}

// rectangle subclass

class Rectangle extends Shape{
    // passing values using constructor
    
    float l, b;
    
    public Rectangle(float l, float b) {
        this.l = l;
        this.b = b;
    }
    // calculate area function
    
    public void calculateArea() {
        System.out.println("Area: " + 2 * (l + b));
    }
}

// triangle subclass 

class Triangle extends Shape{
    // passing values using constructor
    
    float a, b, c;
    
    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    // calculate area function
    
    public void calculateArea() {
        float s = (a + b + c) / 2;
        float area = (float) Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println("Area: " + area);
    }
}
