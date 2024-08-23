// WAP to generate and match captcha 
package String;
import java.util.Random;
import java.util.Scanner;

public class Dummy1 {

  public String Captcha() {
    int index = 0;
    String captcha = "";

    String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&";
    Random r = new Random();
    int strLen = str.length();
    for (int i = 0; i < 6; i++) {
      index = r.nextInt(strLen);
      captcha += str.charAt(index);
    }
    return captcha;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Dummy1 d = new Dummy1();
    String captcha = d.Captcha();
    System.out.println("captcha = " + captcha);

    // scaning user input
    System.out.print("enter aptcha: ");
    String userInput = sc.next();
    System.out.println(userInput);

    // matching the input with captcha value

    if (captcha.equals(userInput)) {
      System.out.println("captcha matched");
    } else {
      System.out.println("captcha not matched");
    }
  }
}
