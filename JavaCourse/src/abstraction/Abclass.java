
package abstraction;

abstract class Abclass {
    public abstract int factorial(int x);
    public abstract int cube(int x);
    public void msg() {
        System.out.println("Good Morning");
    }
}

// simple class inherit Abclass

class Simple extends Abclass {
    public int factorial(int x) {
        int fact = 1, i;
        
        for (i = 1; i <= x; i++) {
            fact = fact * i;
        }
        return fact;
    }
    
    public int cube(int x) {
        return x * x * x;
    }
}
