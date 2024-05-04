// WAP to provide grade to student based on their marks

import java.util.Scanner;
public class oLevelCertificate {
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    int m1, m2, m3, m4;
    float percentage = 0;
   
    System.out.print("Enter mark of m1 = ");
    m1 = sc.nextInt();
    System.out.println();

    System.out.print("Enter mark of m2 = ");
    m2 = sc.nextInt();
    System.out.println();


    System.out.print("Enter mark of m3 = ");
    m3 = sc.nextInt();
    System.out.println();

    System.out.print("Enter mark of m4 = ");
    m4 = sc.nextInt();
    System.out.println();

    percentage = (m1 +m2 +m3 +m4)/4;
    
    if(percentage < 50) {

      System.out.println("The candidate is failed ! ");

    }  else if(percentage < 55) {

         System.out.println("The candidate has got D grade ");

       }  else if(percentage < 65) {

            System.out.println("The candidate has got C ");

          }  else if(percentage < 75) {

               System.out.println("The candidate has got B ");

             } else if(percentage < 85) {

                 System.out.println("The candidate has got A ");

               } else {
                   System.out.println("The candidate has got S grade ");
                 }
    sc.close();
  }
}