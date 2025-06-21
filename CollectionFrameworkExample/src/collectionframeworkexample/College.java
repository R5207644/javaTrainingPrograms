// example of program that show how a ArrayList can use a class as datatype
package collectionframeworkexample;

import java.util.*;

/**
 *
 * @author Sarvesh Kumar
 */
public class College {

    public static void main(String[] args) {
        // declaration
        ArrayList<Student> std = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        int n;

        // entering n
        System.out.print("number of students? : ");
        n = sc.nextInt();
        System.out.println();

        // for loop to add data
        for (int i = 0; i < n; i++) {

            System.out.print("id: ");
            int id = sc.nextInt();
            
            System.out.print("name: ");
            String name = sc.next();
            
            System.out.print("course: ");
            String course = sc.next();
            
            Student s = new Student(id, name, course);
            std.add(s);
        }

//        // declaring student object
//        Student s1 = new Student(1, "sarvesh", "BCA");
//        Student s2 = new Student(2, "Shaipali", "BCA");
//        Student s3 = new Student(3, "Priya", "BCA");
//        Student s4 = new Student(4, "Akash", "BCA");
//        Student s5 = new Student(5, "Vikash", "BCA");
//        // adding in ArrayList
//        std.add(s1);
//        std.add(s2);
//        std.add(s3);
//        std.add(s4);
//        std.add(s5);

        // iterating and printing by for each loop
        System.out.println("Student Details: ");
        for (Student s : std) {
            System.out.println(s.id + ", " + s.name + ", " + s.course);
        }
        
        // search
        System.out.print("Search (?)\n\n");
        
        System.out.print("id: ");
        int id = sc.nextInt();
        
//        // loop over to search
//        for (int i = 0; i < n; i++) {
//            if (std.get(i).id == id) {
//                System.out.println("found");
//                System.out.println(std.get(i).id + ", " + std.get(i).name + ", " + std.get(i).course);
//                break;
//            }
//        }

        // loop over to search and remove
        for (int i = 0; i < n; i++) {
            if (std.get(i).id == id) {
                System.out.println("the following record is deleted");
                System.out.println(std.get(i).id + ", " + std.get(i).name + ", " + std.get(i).course);
                std.remove(std.get(i));
                break;
            }
        }
        
        // iterating and printing by for each element using loop
        System.out.println("updated Student Details: ");
        for (Student s : std) {
            System.out.println(s.id + ", " + s.name + ", " + s.course);
        }
        
    }

}
