
package Library;
import java.util.*;

/**
 *
 * @author sarvesh
 */
public class BookLibrary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declaration
        LinkedList<Book> books = new LinkedList<Book>();
        int n;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("how many books do you want to add? ");
        n = sc.nextInt();
        System.out.println();
        
        for (int i = 0; i < n; i++) {
            System.out.print("book id? ");
            int bookId = sc.nextInt();
            
            System.out.print("quantity? ");
            int quantity = sc.nextInt();
            
            System.out.print("author? ");
            String author = sc.next();
            
            System.out.print("book name? ");
            String bookName = sc.next();
            
            Book book = new Book(bookId, quantity, author, bookName);
            books.add(book);
            
            System.out.println();
        }
        
        for (int i = 0; i < n; i++) {
            books.get(i).display();
        }
    }
    
}
