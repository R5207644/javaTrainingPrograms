package overloading;

// Dummy class
// if final keyword applied here then demo can't be able to inherit it

class Dummy {
    public final void display() {
        System.out.println("Hello, Friends!!");
    }
}

// Demo class

class Demo extends Dummy {
//    public void display() {
//        System.out.println("Good Night");
//    }
}

public class FinalFunction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // object
        
        Demo demo = new Demo();
        demo.display();
    }
    
}
