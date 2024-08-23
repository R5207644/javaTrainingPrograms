public class Calculation {

    // default constructor

    public Calculation() {};

    // constructor

    public Calculation(int l, int b) {
        int a = l * b;
        System.out.println("Area: " + a);
    }

    // cube function

    public int Cube(int n) {
        int cube = n * n * n;
        return cube;
    }
}
