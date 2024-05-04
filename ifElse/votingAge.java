// 6. WAP to check wheather a person is eligible to vote or not in notepad

import java.util.Scanner;
public class votingAge{

  public static int isValidAge() {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter age = ");
    System.out.println();
    int age = sc.nextInt();
    
    if(age >=18) {
      System.out.println("You are eligible to vote !!");
      } else {
               System.out.println("You cannot vote, please drink bourn vita, Thanks ");
	       }
    sc.close();
    return age;

    }


  public static void main(String args[]) {

    isValidAge();
    
    }

}