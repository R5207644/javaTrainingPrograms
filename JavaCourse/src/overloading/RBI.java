
package overloading;

public class RBI {
    // Rate of interest function in parent class
    
    public void ROI() {
        System.out.println("Rate of interest: 7.0%");
    }
}

// child class extents parent class

class PNB extends RBI {
    // rate of interest function in child class
    
    public void ROI() {
        System.out.println("Rate of interest: 7.9%");
    }
}
