//WAP to enter name and gender of employees in separate arrays

import java.util.Scanner;
public class NameGender {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] name = new String[10], gender = new String[10];
    int n;
    
    System.out.print("enter no. of employees you want to add = ");
    n = sc.nextInt();
    System.out.println();
    
    //Taking inputs
    System.out.println("enter name and gender = ");
    for(int i = 0; i < n; i++) {
      name[i] = sc.nextLine();
      gender[i] = sc.next();
      System.out.println("you entered index no . "+i +" sucessfully !!");
    }
    System.out.println();
    
    //Updating name as mr or mrs
    
    for(int i = 0; i < n; i++) {
      if(gender[i].equals("male")) {
        name[i] = "mr "+ name[i];
      } else if(gender[i].equals("female")) {
        name[i] = "mrs " + name[i];
      }
    }
    
    //Printing Names 
    
    System.out.print("Entered names = ");
    for(int i = 0; i < n; i++) {
      System.out.print(name[i] + "\t");
    }
    System.out.println();
    sc.close();
  }
}
