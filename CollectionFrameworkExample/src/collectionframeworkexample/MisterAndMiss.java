
package collectionframeworkexample;
import java.util.*;

/**
 *
 * @author sarvesh kumar
 */
public class MisterAndMiss {

    
    public static void main(String[] args) {
        // declaring 
        int n;
        String name, gender;
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> genders = new ArrayList<String>();
        
        System.out.print("how many records do you want to add ? ");
        n = sc.nextInt();
        
        // insertion
        for (int i = 0; i < n; i++) {
            System.out.print("name : ");
            name = sc.next();
            names.add(name);
            
            System.out.print("gender : ");
            gender = sc.next();
            genders.add(gender);
            
            System.out.println();
        }
        
        // operation
        for (int i = 0; i < n; i++) {
            if (genders.get(i).equals("male")) {
                names.set(i, "mr. " + names.get(i));
            } else {
                names.set(i, "miss " + names.get(i));
            }
        }
        
        // printing
        System.out.println(names);
    }
    
}
