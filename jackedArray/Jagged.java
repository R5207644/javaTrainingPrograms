// WAP to insert and print data of jagged array

import java.util.Scanner;
class jagged {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] arr = new int[4][];
    
    for(int i = 0; i < 4; i++) {
      System.out.print("length arr [" + i + "]: ");
      int n = sc.nextInt();
      System.out.println();
      arr[i] = new int[n];
    }

    // inserting data

    for(int i = 0; i < 4; i++) {
      for(int j = 0; j < arr[i].length; j++) {
        System.out.print("arr[" + i + "] [" + j + "]: ");
        arr[i][j] = sc.nextInt();
        System.out.println();
      }
    }

    // printing array

    System.out.println("Array: ");
    for(int i = 0; i < 4; i++) {
      for(int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + "\t");
      }
      System.out.println();
    }
    sc.close();
  }
}