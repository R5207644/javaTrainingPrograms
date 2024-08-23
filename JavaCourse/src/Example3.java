interface myInt1 {

    public int cube(int n);
    
    public int rectangle(int a, int b);
}

abstract class myInt2 implements myInt1{
       
    public abstract int fact(int n);
}

class Dummy3 extends myInt2 {
    
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

public class Example3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Dummy3 dummy = new Dummy3();
        System.out.println("cube: " + dummy.cube(7));
        System.out.println("area: " + dummy.rectangle(10, 12));
        System.out.println("factorial: " + dummy.fact(5));
    }
    
}
