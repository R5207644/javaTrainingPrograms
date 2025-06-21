package collectionframeworkexample;

import java.util.*;

/**
 *
 * @author sarvesh
 */
public class HashMapExample {

    public static void main(String[] args) {
        // HashMap Example
        HashMap<String, String> dict = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);

        dict.put("Apple", "Shev");
        dict.put("Boy", "Ladaka");
        dict.put("Cat", "Bilar");
        dict.put("Dog", "Kukkur");
        dict.put("Elephant", "Hathi");
        dict.put("Fish", "Machari");
        dict.put("Goan", "Bakri");
        dict.put("Hen", "Murgi");
        dict.put("iceCream", "Baraf");
        dict.put("Jokar", "Jokad");
        dict.put("Kite", "Patang");
        dict.put("Lion", "Sher");
        dict.put("Mango", "Aam");
        dict.put("Nest", "Ghosla");
        dict.put("Owl", "Shaipali");
        dict.put("Parrat", "Tota");
        dict.put("Queen", "Rani");
        dict.put("Rose", "Gulabe ka Fool");
        dict.put("Sun", "Suru Narayan");
        dict.put("Toy", "Khilauna");
        dict.put("Umbrella", "Chata");
        dict.put("Van", "Gadi");
        dict.put("Watch", "Ghadi");
        dict.put("X-mas", "X-mas");
        dict.put("Year", "Saal");
        dict.put("Zebra", "Zebra");
        
        dict.replace("Apple", "Red Fruit");
        dict.remove("Zebra");
        dict.putIfAbsent("Black", "Kala");

        // printing part
        System.out.println("Dictionary");

        System.out.print("word: ");
        String word = sc.next();
        System.out.println();

        for (Map.Entry x : dict.entrySet()) {
            if (x.getKey().toString().toUpperCase().equals(word.toUpperCase())) {
                System.out.println(x.getValue());
            }
        }

    }

}
