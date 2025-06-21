package GuiExamples;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;

public class DOBSelect {

  public void dob() {
    Frame f = new Frame("DOB");

    // Decalaring choice boxes
    Choice day = new Choice();
    Choice month = new Choice();
    Choice year = new Choice();

    // adding choices
    day.add("1");
    day.add("2");
    day.add("3");
    day.add("4");
    day.add("5");
    day.add("6");
    day.add("7");
    day.add("8");
    day.add("9");
    day.add("10");
    day.add("11");
    day.add("12");
    day.add("13");
    day.add("14");
    day.add("15");
    day.add("17");
    day.add("18");
    day.add("19");
    day.add("20");
    day.add("21");
    day.add("22");
    day.add("23");
    day.add("24");
    day.add("25");
    day.add("26");
    day.add("27");
    day.add("28");
    day.add("29");
    day.add("30");
    day.add("31");

    // Month
    month.add("January");
    month.add("February");
    month.add("March");
    month.add("April");
    month.add("May");
    month.add("June");
    month.add("July");
    month.add("August");
    month.add("September");
    month.add("October");
    month.add("November");
    month.add("December");

    // Year
    year.add("1990");
    year.add("1991");
    year.add("1992");
    year.add("1993");
    year.add("1994");
    year.add("1995");
    year.add("1996");
    year.add("1997");
    year.add("1998");
    year.add("1999");
    year.add("2000");
    year.add("2001");
    year.add("2002");
    year.add("2003");
    year.add("2004");

    // seting bounds
    day.setBounds(100, 100, 50, 30);
    month.setBounds(200, 100, 100, 30);
    year.setBounds(350, 100, 50, 30);

    // adding component to frame
    f.add(day);
    f.add(month);
    f.add(year);

    // defining window property
    f.setBackground(Color.GRAY);
    f.setSize(600, 400);
    f.setLayout(null);
    f.setVisible(true);
  }
}