// WAP of Rock Paper and seissor game using java
import java.io.Console;
public class RockPaper {
  public static void main(String[] args) {
    Console console = System.console();
    char[] ch1, ch2;
    
    System.out.println("Enter for R for Rock, P for Paper, S for Seissor = ");
    ch1 = console.readPassword("enter your choice = ");
    
    System.out.println("Enter R for Rock, P for Paper, S for Seissor = ");
    ch2 = console.readPassword("enter your choice = ");
    
    while(ch1.equals('R')){
      if(ch2.equals('R')) {
        System.out.println("draw");
      } else if(ch2.equals('P')) {
        System.out.println("Player 2 won !!");
      } else if(ch2.equals('S')) {
        System.out.println("Player 1 won !!");
      }
      break;
    }
    
    while(ch1.equals('P')){
      if(ch2.equals('R')) {
        System.out.println("Player 1 won");
      } else if(ch2.equals('P')) {
        System.out.println("draw !!");
      } else if(ch2.equals('S')) {
        System.out.println("Player 2 won!!");
      }
      break;
    }
    
    while(ch1.equals('S')){
      if(ch2.equals('R')) {
        System.out.println("Player 2 won !!");
      } else if(ch2.equals('P')) {
        System.out.println("Player 1 won !!");
      } else if(ch2.equals('S')) {
        System.out.println("Draw !!");
      }
      break;
    }
    
  }
}
