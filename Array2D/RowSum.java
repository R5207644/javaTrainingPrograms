//WAP to print sum of row
import java.util.Scanner;
public class RowSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] matrix = new int[10][10];
    int row,col, sum = 0;
    
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
        sum = sum + matrix[i][j];
      }
      System.out.print("sum = " + sum);
      System.out.println();
      sum = 0;
    }
    sc.close();
  }
}
