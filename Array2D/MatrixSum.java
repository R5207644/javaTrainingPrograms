//WAP to print sum two matrix
import java.util.Scanner;
public class MatrixSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] matrix1 = new int[10][10];
    int[][] matrix2 = new int[10][10];
    int[][] sum = new int[10][10];
    int row1,col1, row2, col2;
    //inserting matrix 2
    System.out.println("enter row and column size for matrix1 = ");
    row1 = sc.nextInt();
    col1 = sc.nextInt();
    
    System.out.println("enter matrix1 = ");
    for(int i = 0; i < row1; i++) {
      for(int j = 0; j < col1; j++) {
        matrix1[i][j] = sc.nextInt();
      }
    }
    //inserting matrix 2
    System.out.println("enter row and column size for matrix2 = ");
    row2 = sc.nextInt();
    col2 = sc.nextInt();
    
    System.out.println("enter matrix2 = ");
    for(int i = 0; i < row2; i++) {
      for(int j = 0; j < col2; j++) {
        matrix2[i][j] = sc.nextInt();
      }
    }
    
    //adding both matrix and store in third matrix when and only when both have same row and column values
    if(row1 == row2 && col1 == col2) {
      for(int i = 0; i < row2; i++) {
        for(int j = 0; j < col2; j++) {
          sum[i][j] = matrix1[i][j] + matrix2[i][j];
        }
      }
    }
    
    //printing sum of matrix
    System.out.println("sum = ");
    for(int i = 0; i < row2; i++) {
      for(int j = 0; j < col2; j++) {
        System.out.print(sum[i][j]+"\t");
      }
      System.out.println();
    }
    
    sc.close();
  }
}
