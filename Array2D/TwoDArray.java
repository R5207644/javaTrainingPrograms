//WAP to input and and print a 2D Array
import java.util.Scanner;
public class TwoDArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] matrix = new int[10][10];
    int row,col;
    
    System.out.println("enter row and column size  = ");
    row = sc.nextInt();
    col = sc.nextInt();
    
    System.out.println("enter matrix = ");
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
    
    System.out.println("my matrix is = ");
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        System.out.print(matrix[i][j] + "\t");
      }
      System.out.println();
    }
    
    System.out.println("transpose of matrix is = ");
    for(int i = 0; i < col; i++) {
      for(int j = 0; j < row; j++) {
        System.out.print(matrix[j][i] + "\t");
      }
      System.out.println();
    }
    sc.close();
  }
}
