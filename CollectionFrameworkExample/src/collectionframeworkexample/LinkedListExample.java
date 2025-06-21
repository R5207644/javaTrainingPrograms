package collectionframeworkexample;

import java.util.*;

/**
 *
 * @author Sarvesh Kumar
 */
public class LinkedListExample {

    public static void main(String[] args) {
        // declaration
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> arr = new LinkedList<>();
        int n;

        System.out.print("number of records: ");
        n = sc.nextInt();
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter " + (i + 1) + "st data: ");
            int data = sc.nextInt();
            arr.add(data);
            System.out.println();
        }

        System.out.println("list is: " + arr);
        
        // addFirst
        arr.addFirst(10);
        
        System.out.println("after addFirst list is: " + arr);
        
        // addLast
        arr.addLast(19);
        
        System.out.println("after addLast list is: " + arr);

    }

}
