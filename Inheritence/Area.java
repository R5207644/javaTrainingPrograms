package Inheritence;

public class Area {
  public float area(int a) {
    float x = 3.14f * a* a;
    return x;

  }

  public float area(int a, int b) {
   float y = 2* (a +b); 
   return y;
  }

  public double area(int a, int b, int c) {
    float s = (a+b+c)/2;
    double y = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    return y;
  }

  public static void main(String[] args) {
    Area a = new Area();
    System.out.println("area: " + a.area(10));
    System.out.println("area: " + a.area(12, 4));
    System.out.println("area: " + a.area(4, 4, 4));
  }
}
