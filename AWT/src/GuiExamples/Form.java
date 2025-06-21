package GuiExamples;

import java.awt.*;

public class Form {

    public void myForm() {

        Frame f = new Frame("Registration Form");

        Label l1 = new Label("First Name : ");
        l1.setBounds(100, 100, 150, 30);

        TextField t1 = new TextField();
        t1.setBounds(280, 100, 150, 30);

        Label l2 = new Label("Second Name : ");
        l2.setBounds(100, 150, 150, 30);

        TextField t2 = new TextField();
        t2.setBounds(280, 150, 150, 30);

        Label l3 = new Label("Result : ");
        l3.setBounds(100, 200, 150, 30);

        TextField t3 = new TextField();
        t3.setBounds(280, 200, 150, 30);

        // buttons
        Button b1 = new Button("sum");
        b1.setBounds(170, 270, 50, 30);

        Button b2 = new Button("sub");
        b2.setBounds(240, 270, 50, 30);

        Button b3 = new Button("mul");
        b3.setBounds(310, 270, 50, 30);

        Button b4 = new Button("div");
        b4.setBounds(380, 270, 50, 30);

        Button b5 = new Button("clr");
        b5.setBounds(450, 270, 50, 30);

        // Adding Components
        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(l3);
        f.add(t3);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);

        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
