package Inheritence;

public class Example {
  public static void main(String[] args) {
    Overloading obj = new Overloading();

    System.out.println("sum1: " + obj.sum(10, 20));
    System.out.println("sum2: " + obj.sum(10, 20, 30));
    System.out.println("sum3: " + obj.sum(10, 20, 30, 40));
  }
}
