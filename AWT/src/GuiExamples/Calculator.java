package GuiExamples;

import java.awt.*;

/**
 *
 * @author Sarvesh Kumar
 */
public class Calculator {

    public void calc() {
        Frame f = new Frame("Calculator");

        // First TextField
        TextField t = new TextField();
        t.setBounds(0, 0, 400, 80);

        // Buttons of first row
        Button b1 = new Button("7");
        Button b2 = new Button("8");
        Button b3 = new Button("9");
        Button b4 = new Button("+");

        b1.setBounds(0, 80, 100, 80);
        b2.setBounds(100, 80, 100, 80);
        b3.setBounds(200, 80, 100, 80);
        b4.setBounds(300, 80, 100, 80);

        // Buttons of second row
        Button b5 = new Button("4");
        Button b6 = new Button("5");
        Button b7 = new Button("6");
        Button b8 = new Button("-");

        b5.setBounds(0, 160, 100, 80);
        b6.setBounds(100, 160, 100, 80);
        b7.setBounds(200, 160, 100, 80);
        b8.setBounds(300, 160, 100, 80);

        // Buttons of third row
        Button b9 = new Button("1");
        Button b10 = new Button("2");
        Button b11 = new Button("3");
        Button b12 = new Button("*");

        b9.setBounds(0, 240, 100, 80);
        b10.setBounds(100, 240, 100, 80);
        b11.setBounds(200, 240, 100, 80);
        b12.setBounds(300, 240, 100, 80);

        // Buttons of fourth row
        Button b13 = new Button("0");
        Button b14 = new Button(".");
        Button b15 = new Button("/");
        Button b16 = new Button("=");

        b13.setBounds(0, 320, 100, 80);
        b14.setBounds(100, 320, 100, 80);
        b15.setBounds(200, 320, 100, 80);
        b16.setBounds(300, 320, 100, 80);

        // Adding Elements to Frame
        f.add(t);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b10);
        f.add(b11);
        f.add(b12);
        f.add(b13);
        f.add(b14);
        f.add(b15);
        f.add(b16);

        // Defining window Properties
        f.setBackground(Color.GREEN);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
