
package overloading;

public class Overriding {

    public static void main(String[] args) {
        // object of PNB
        
//        PNB pnb = new PNB();
//        
//        // calling ROI function
//        
//        pnb.ROI();

    Circle circle = new Circle(10.5f);
    circle.calculateArea();
    
    Rectangle rectangle = new Rectangle(10.5f, 12.7f);
    rectangle.calculateArea();
    
    Triangle triangle = new Triangle(4f, 5f,4f);
    triangle.calculateArea();
    }
    
}
