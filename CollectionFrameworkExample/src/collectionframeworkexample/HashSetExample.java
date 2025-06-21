package collectionframeworkexample;

import java.util.*;

/**
 *
 * @author sarvesh
 */
public class HashSetExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // accesing Hashset Using object

        HashSet<String> hs = new HashSet<String>();
        Scanner sc = new Scanner(System.in);
        hs.add("sarvesh");

        System.out.print("how many names do you want to add? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("name: ");
            String name = sc.next();
            hs.add(name);
            System.out.println();
        }
//        hs.remove("sarvesh");
        
        hs.removeIf(str -> str.contains("sarvesh"));
        System.out.println(hs);
    }

}
