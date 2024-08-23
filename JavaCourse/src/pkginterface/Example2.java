interface myInt1 {

    public int cube(int n);
    
    public int rectangle(int a, int b);
}

interface myInt2 extends myInt1{

    public int fact(int n);
}

class Dummy2 implements myInt2 {
    
    @Override
    public int cube(int n) {
        return n * n * n;
    }
    
    @Override
    public int rectangle(int a, int b) {
        return a * b;
    }
    
    @Override
    public int fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        
        return fact;
    }
    
}

public class Example2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Dummy2 dummy = new Dummy2();
        System.out.println("cube: " + dummy.cube(7));
        System.out.println("area: " + dummy.rectangle(10, 12));
        System.out.println("factorial: " + dummy.fact(5));
    }
    
}
