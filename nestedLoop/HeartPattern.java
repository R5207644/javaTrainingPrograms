// WAP to print heart Star pattern using nested for loop

import java.util.Scanner;

public class HeartPattern {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    
    System.out.print("Enter n = ");
    n = sc.nextInt();
    System.out.println();
    
    for(int i = 1; i<=n/2; i++) {
    
      for(int j=n/2; j>=i; j--)
      {
        System.out.print(" ");
      }
      
      for(int j = 1; j<=i; j++) {
        if(i < n/4) {System.out.print(" ");} 
        else {System.out.print("*");}
      }
      
      for(int j=1; j<i; j++) {
        if(i < n/4) {System.out.print(" ");} 
        else {System.out.print("*");}
      }
      for(int j=n/2; j>=i; j--)
      {
        System.out.print(" ");
      }
      for(int j=n/2; j>=i; j--)
      {
        System.out.print(" ");
      }
      
      for(int j = 1; j<=i; j++) {
        if(i < n/4) {System.out.print(" ");} 
        else {System.out.print("*");}
      }
      
      for(int j=1; j<i; j++) {
        if(i < n/4) {System.out.print(" ");} 
        else {System.out.print("*");}
      }
      
      System.out.println();
      
    }
    
    for(int i = n; i>=1; i--) {
    
      for(int j=i; j<=n; j++)
      {
        System.out.print(" ");
      }
      
      for(int j = i; j>=1; j--) {
            System.out.print("*");
      }
      
      for(int j=i; j>1; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
      
    sc.close();
  }
}
