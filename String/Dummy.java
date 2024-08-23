package String;
// Make a dummy file to input and orint string

class Dummy {
  public static void main(String[] args) {

    // declaring the Sting

    // String s1 = "twinkle twinkle little star";
    // String s2 = "TWINKLE TWINKLE LITTLE STAR";

    // printing the strings

    // System.out.println("String 1 in upper case : " + s1.toUpperCase());
    // System.out.println("String 2 in Lower case : " + s2.toLowerCase());
    // System.out.println("Length of String2 : " + s2.length());

    // System.out.println("String 1 after replace twinkle with hello : " + s1.replace("twinkle", "hello"));
    // String[] words=s1.split(" ");
    // for(String w:words)
    // {
    //   System.out.println(w);
    // }

    // trim function

    // String s1 = "        Hello World       ";
    // System.out.println(s1.trim());
    // System.out.println("length before trim: " + s1.length());
    // System.out.println("length after trim: " + s1.trim().length());

    // index of and last index of

    // String s1 = "twinkle twinkle little star";
    // String s1 = "twinkle twinkle little star";
    // System.out.println(s1.indexOf("twinkle"));
    // System.out.println(s1.lastIndexOf("twinkle"));

    //
    String s1 = "noida";
    String s2 = "NOIDA";

    if(s1.equalsIgnoreCase(s2)) {
      System.out.println("equal");
    }
    else {
      System.out.println("not equal");
    }
    
  }
}