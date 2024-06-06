//WAP to calculate bonus and add it to salary

import java.util.Scanner;
public class Bonus {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    float bonus;
    
    System.out.print("enter no. of employees = ");
    n = sc.nextInt();
    System.out.println();
    
    String[] name = new String[n];
    float[] salary = new float[n];
    
    System.out.println("enter name and salary of employees = ");
    
    //entering name and salary of employees
    for(int i = 0; i < n; i++) {
      System.out.println("enter details at index "+ i +" = ");
      name[i] = sc.next();
      salary[i] = sc.nextInt();
    }
    
    //updating bonus in salary and printing
    for(int i = 0; i < n; i++) {
      if(salary[i] >= 40000) {
        bonus = salary[i]*0.5f;
      } else if(salary[i] >=30000 && salary[i] < 40000) {
        bonus = salary[i] * 0.25f;
      } else if(salary[i] >= 20000 && salary[i] < 30000) {
        bonus = salary[i] * .18f;
      } else {
        bonus = salary[i] * 0.10f;
      }
      System.out.println(name[i] + " base salary = " +salary[i] + " bonus = " +bonus +"\t final salary = "+ (salary[i]+bonus));
      salary[i] = (salary[i] + bonus);
    }
    sc.close();
  }
}
