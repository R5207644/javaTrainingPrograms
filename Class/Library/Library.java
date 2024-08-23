
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {

        // Declaring arrays of book and Student

        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[3];
        Student[] student = new Student[3];

        // inserting books

        System.out.println("Enter Book ->");

        for (int i = 0; i < 3; i++) {

            int bookId = i+1000;

            System.out.print("quantity: ");
            int quantity = sc.nextInt();
            System.out.println();

            System.out.print("book name: ");
            String bookName = sc.next();
            System.out.print("\t");

            // assigning values using sonstructor

            books[i] = new Book(bookId, quantity, bookName);
            System.out.println("Bookid = " + bookId);

        }

        // inserting students

        System.out.println("Enter Student->");

        for (int i = 0; i < 3; i++) {

            int stdId = i + 3000;
            
            System.out.print("name: ");
            String name = sc.next();
            System.out.println();

            System.out.print("course: ");
            String course = sc.next();
            System.out.print("\t");

            student[i] = new Student(stdId, name, course);
            System.out.println("student id = " + stdId);
        }

        // book issue code

        System.out.println("Enter Student details ->");

        System.out.print("Student id: ");
        int studentId = sc.nextInt();
        System.out.println();

        System.out.print("Book id: ");
        int bookId = sc.nextInt();

        // checking student and book

        int st = 0, bk = 0;
        for (int i = 0; i < 3; i++) {
            if (studentId == student[i].stdId) {
                st = 1;
            }
            if (bookId == books[i].bookId) {
                bk = 1;
                if (st == 1) {
                    System.out.println("book issued sucessfully !!");
                    return;
                }
            }
        }

        if (st == 1 && bk == 1) {
            System.out.println("book issued sucessfully !!");
        } else {
            System.out.println("book not issued !!");
        }

        sc.close();
    }
}
