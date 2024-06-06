//WAP to insert a value at first index of array

import java.util.Scanner;

public class InsertAtFirst {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[6];

    System.out.println("enter array = ");
    for(int i = 0; i < 5; i++) {
      arr[i] = sc.nextInt();
    }

    //element that is going to be inserted
    System.out.print("number: ");
    int n = sc.nextInt();
    System.out.println();

    // iterating elements to insert value
    for(int i = 5; i > 0; i--) {
      arr[i] = arr[i-1];
    }
    arr[0] = n;

    // printing array
    for(int i = 0; i <= 5; i++) {
      System.out.print(arr[i] + "\t");
    }
    sc.close();
    
  }
}