
package collectionframeworkexample;
import java.util.*;

/**
 *
 * @author Sarvesh Kumar
 */
public class ArrayListExample {

    
    public static void main(String[] args) {
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.add(70);
        arr.add(101);
        arr.add(102);
        arr.add(105);
        
        // by for each loop
//        System.out.println("My arr list is:");
//        
//        for (Integer x : arr) {
//            System.out.println(x);
//        }
        
        // by iterator
        System.out.println("My array is:");
        Iterator itr = arr.iterator();
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    
}
