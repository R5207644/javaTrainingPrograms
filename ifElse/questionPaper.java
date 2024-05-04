// WAP of a question paper to took exam and evaluate its result

import java.util.Scanner;

public class questionPaper {

  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    int correct=0, incorrect=0, marks, ch=0;
    
    System.out.println("first man to reach space - ");
    System.out.println("1. neel armstrong ");
    System.out.println("2. yuri gagrin ");
    System.out.println("3. neel Rakesh Sharma ");
    System.out.println("4. Marry Query ");
    
    ch = sc.nextInt();
    System.out.println();
    
    if(ch == 2) {
      correct++;
    } else {
        incorrect++;
      }

    System.out.println("Capital city of INDIA - ");
    System.out.println("1. New Delhi ");
    System.out.println("2. Mumbai ");
    System.out.println("3. Gujrat ");
    System.out.println("4. UP ");
    
    ch = sc.nextInt();
    System.out.println();

    
    if(ch == 1) {
      correct++;
    } else {
        incorrect++;
      }

    System.out.println("Capital of USA - ");
    System.out.println("1. New York city ");
    System.out.println("2. washington DC ");
    System.out.println("3. Tokyo ");
    System.out.println("4. Parris ");
    
    ch = sc.nextInt();
    System.out.println();

    
    if(ch == 2) {
      correct++;
    } else {
        incorrect++;
      }

    System.out.println("Where Mahadev PG college situated - ");
    System.out.println("1. Bariyasanpur ");
    System.out.println("2. Gaura ");
    System.out.println("3. Chiraigaon ");
    System.out.println("4. Barai ");
    
    ch = sc.nextInt();
    System.out.println();

    
    if(ch == 1) {
      correct++;
    } else {
        incorrect++;
      }

    System.out.println("Creater of python - ");
    System.out.println("1. guiso wan rossum ");
    System.out.println("2. Mark Jukerberg");
    System.out.println("3. Devid J Malan ");
    System.out.println("4. Brian Yu ");
    
    ch = sc.nextInt();
    System.out.println();

    
    if(ch == 1) {
      correct++;
    } else {
        incorrect++;
      }
   marks = (correct*5) - (incorrect*2);
  
    System.out.println("correct ans = " + correct + " Incorrect ans = " + incorrect + " marks = " + marks);
    sc.close();
    
  }
}