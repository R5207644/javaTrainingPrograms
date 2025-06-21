
package collectionframeworkexample;
import java.util.*;

/**
 *
 * @author sarvesh kumar
 */
public class NameArraiListExample {


    public static void main(String[] args) {
        // declaring variables
        Scanner sc = new Scanner(System.in);
        String name;
        int n;
        ArrayList<String> names = new ArrayList<String>();
        
        System.out.print("How many names you want to add ? ");
        n = sc.nextInt();
        System.out.println();
        
        for (int i = 1; i <= n; i++) {
            System.out.print("name : ");
            name = sc.next();
            names.add(name);
            System.out.println();
        }
        
        // printing names
        for (String x : names) {
            System.out.print("\t" + x + "\t");
        }
        
    }
    
}
