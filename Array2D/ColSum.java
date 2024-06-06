//WAP to print sum of column
import java.util.Scanner;
public class ColSum {
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
    
    for(int i = 0; i < col; i++) {
      for(int j = 0; j < row; j++) {
        sum = sum + matrix[j][i];
      }
      System.out.print("sum of column "+i+" = " + sum);
      System.out.println();
      sum = 0;
    }
    
    sc.close();
  }
}
