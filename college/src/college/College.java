package college;

import java.util.Scanner;

/**
 *
 * @author Sarvesh
 */
public class College {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("First Number: ");
        int a = sc.nextInt();
        System.out.println();
        System.out.print("Second Number: ");
        int b = sc.nextInt();
        System.out.println();
        int c = a + b;
        System.out.println("sum: " + c);
    }

}
