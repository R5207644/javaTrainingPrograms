import java.util.Scanner;

public class EmployeeArray {
    public static  void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // declaring employee array

        Employee[] emp = new Employee[5];

        // using loop to insert data

        for(int i = 0; i < 5; i++) {

            int id = i+1;

            System.out.print("name: ");
            String name = sc.next();
            System.out.println();

            System.out.print("salary of " + name + " : ");
            float salary = sc.nextFloat();
            System.out.println();

            emp[i] = new Employee(id, name, salary);
        }

        // display employee value 

        for(int i = 0; i < 5; i++) {

            emp[i].Display();
            
        }

        sc.close();
    }
}
