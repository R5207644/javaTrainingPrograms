package String;

public class StringExample {
  public static void main(String[] args) {
    // // declaring the Stingbuffer

    // StringBuffer sb = new StringBuffer("Good Morning");
    // System.out.println("my string is: " + sb);

    // // append function

    // sb.append(" Good Night");
    // System.out.println("after append: " + sb);

    // // insert function

    // sb.insert(2, " java programming");
    // System.out.println("after insert: " + sb);

    // // replace function

    // sb.replace(2, 5, "python");
    // System.out.println("after replace: " + sb);

    // // reverse function

    // sb.reverse();
    // System.out.println("after reverse: " + sb);

    // // delete function

    // sb.delete(2, 7);
    // System.out.println("after delete: " + sb);

    StringBuffer sb1 = new StringBuffer();
    System.out.println(sb1.capacity());

    sb1.append("Ram");
    System.out.println(sb1.capacity());

    sb1.append("twinkle twinkle little star");
    System.out.println(sb1.capacity());
  }
}
