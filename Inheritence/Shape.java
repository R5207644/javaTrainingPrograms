package Inheritence;

import java.util.Scanner;

public class Shape {
  public void area() {
    Scanner sc = new Scanner(System.in);

    System.out.println("enter radius of circle: ");
    int radius = sc.nextInt();

    float area = 3.14f * radius * radius;

    System.out.println("Area of Circle is: " + area);
  }
}

class Circle extends Shape {
  Scanner sc = new Scanner(System.in);
  public void perimeter() {
    System.out.println("Enter Radius of Circle: ");

    int radius = sc.nextInt();

    float perimeter = 3.14f * 2 * radius;

    System.out.println("Area of Circle is: " + perimeter);
  }
}

class calculation {
  public static void main(String[] args) {
    Circle c = new Circle();
    c.area();
    c.perimeter();
  }
}
