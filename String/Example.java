package String;

public class Example {

  // String function

  public static String getString() {
    String s = "java";
    for (int i = 0; i < 100000; i++) {
      s += "Programming";
    }
    return s;
  }

  // StringBuffer function

  public static String getStringBuffer() {
    StringBuffer sb = new StringBuffer("java");

    for (int i = 0; i < 100000; i++) {
      sb.append("Programming");
    }
    return sb.toString();
  }

  // StringBuilder function

  public static String getStringBuilder() {
    StringBuilder sb1 = new StringBuilder("java");

    for (int i = 0; i < 100000; i++) {
      sb1.append("Programming");
    }
    return sb1.toString();
  }

  // Main function  Start from here

  public static void main(String[] args) {

    // Time calculating for string

    long startTime = System.currentTimeMillis();
    getString();
    System.out.println("Time Taken: " + (System.currentTimeMillis() - startTime));

    // time calculating for StringBuffer

    startTime = System.currentTimeMillis();
    getStringBuffer();
    System.out.println("Time Taken: " + (System.currentTimeMillis() - startTime));

    // time taken by StringBuilder

    startTime = System.currentTimeMillis();
    getStringBuilder();
    System.out.println("Time Taken: " + (System.currentTimeMillis() - startTime));
  }
}
