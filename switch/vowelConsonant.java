//WAP to check consonant and vowel using switch statement

import java.util.Scanner;

class vowelConsonant {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    char character;

    System.out.print("Enter your character = ");
    character = sc.next().charAt(0);
    System.out.println();

    switch(character) {

      case 'A':
        System.out.println("vowel");
        break;
      case 'E':
        System.out.println("vowel");
        break;
      case 'I':
        System.out.println("vowel");
        break;
      case 'O':
        System.out.println("vowel");
        break;
      case 'U':
        System.out.println("vowel");
        break;
      case 'a':
        System.out.println("vowel");
        break;
      case 'e':
        System.out.println("vowel");
        break;
      case 'i':
        System.out.println("vowel");
        break;
      case 'o':
        System.out.println("vowel");
        break;
      case 'u':
        System.out.println("vowel");
        break;
      default:
        System.out.println("consonant");
    }
    sc.close();
  }
}