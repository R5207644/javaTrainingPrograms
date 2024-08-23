package AcessModifier;

class Dummy {
    private int x = 20;
    private void msg() {
        System.out.println("Good Morning");
    }
}

public class PrivateClass {

    public static void main(String[] args) {
        // lets check if private method acessed or not
        
//        Dummy d = new Dummy();
//        System.out.println(d.x);
//        d.msg();
        
        // we got error in acessing means private methods cannot be acessed 
        // outside function
    }
    
}
