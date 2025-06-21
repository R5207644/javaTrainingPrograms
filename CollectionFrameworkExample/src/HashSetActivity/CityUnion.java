package HashSetActivity;

import java.util.*;

/**
 *
 * @author sarvesh
 */
public class CityUnion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashSet<String> city1 = new HashSet<String>();
        HashSet<String> city2 = new HashSet<String>();
        HashSet<String> city3 = new HashSet<String>(); 

        //city1
        city1.add("varanasi");
        city1.add("kanpur");
        city1.add("Ghazipur");

        // city2
        city2.add("varanasi");
        city2.add("kanpur");
        city2.add("mirzapur");
        city2.add("delhi");
        city2.add("banglore");

        // finding intersection
        for (String name : city1) {
            if (city2.contains(name) == false) {
                city3.add(name);
            }
        }
        
        System.out.println(city3);
    }
    
}
