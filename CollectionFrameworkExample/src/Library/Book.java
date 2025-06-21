package Library;

/**
 *
 * @author Sarvesh
 */
public class Book {

    int bookId, quantity;
    String author, bookName;

    public Book(int bookId, int quantity, String author, String bookName) {
        this.bookId = bookId;
        this.quantity = quantity;
        this.bookName = bookName;
        this.author = author;
    }

    public void display() {
        System.out.println("id: " + bookId + " quantity: " + quantity + " author: " + author + " name: " + bookName);
    }

}
