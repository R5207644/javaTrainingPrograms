// WAP to authenticate username and password using nested if else

import java.util.Scanner;

public class userPasswordAuthentication {

  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    String user, password;

    System.out.print("Enter user name = ");
    user = sc.next();
    System.out.println();

    if(user.equals("R5207644")) {

      System.out.print("Enter Password = ");
      password = sc.next();
      System.out.println();

      if(password.equals("password")) {

        System.out.println("You are sucessfully logged in !!");

      } else {

          System.out.println("worng password !!");

        }

    } else {

        System.out.println("wrong user name !!");

      }
    sc.close();
  }
}