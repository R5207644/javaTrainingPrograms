// WAP to print kite pattern using nested Loop

import java.util.Scanner;

public class KitePattern {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, i, j, k;
    
    System.out.print("enter n = ");
    n = sc.nextInt();
    System.out.println();
    
     for(i = 0; i < n; i++) {
       for(j = 0; j < n; j++) {
       
         if(i == 0 || i == n-1) {
           if(j == n/2) {
             System.out.print("*");
           } else {
             System.out.print(" ");
           }
         } else if(i <= n/2 ) {
           if(j == n/2-i || j == n/2+i) {
             System.out.print("*");
           } else {
             System.out.print(" ");
           }
         } else if(i > n/2 && i < n) {
           if(j == n/2- (n-i-1) || j == n/2 +(n - i-1)) {
             System.out.print("*");
           } else {
             System.out.print(" ");
           }
         }
       }
       System.out.println();
     }
     for(i = 0; i< n/2; i++) {
       for(j = 0; j < n-1; j++) {
         if(i < n/2-1) {
           if(j == n/2-i || j == n/2+i) {
             System.out.print("*");
           } else {
             System.out.print(" ");
           }
         } else {
           if(j== 0){ System.out.print(" ");}
           else{System.out.print("*");}
         }
       }
       System.out.println();
     }
    sc.close();
  }
}
