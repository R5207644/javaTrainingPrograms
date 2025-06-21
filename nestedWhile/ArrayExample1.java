import java.util.Scanner;
class ArrayExample1
{
public static void main(String[] args) 
{
int[] num = new int[10];
int i, sum = 0;

Scanner sc = new Scanner(System.in);
System.out.println("Enter Array Elements");

for(i = 0 ; i < 10; i++)
{
 num[i] = sc.nextInt();
  
}
System.out.println("list of array elements");

for(i = 0; i < 10; i++)
{
  System.out.println(num[i]);
  sum = sum + num[i];
}
  System.out.println("sum =" + sum);



}
}