
package MiniPrograms;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    
    TextField t1, t2, t3;
    Label l1, l2, l3;
    Frame f;
    Button b1, b2, b3, b4, b5;
    
    public Calculator() {
        f = new Frame("Student Details");
        
        // component declaration
        l1 = new Label("First Number : ");
        t1 = new TextField();
        l1.setBounds(100, 100, 150, 30);
        t1.setBounds(300, 100, 150, 30);
        
        l2 = new Label("Second Number : ");
        t2 = new TextField();
        l2.setBounds(100, 150, 150, 30);
        t2.setBounds(300, 150, 150, 30);
        
        l3 = new Label("Result : ");
        t3 = new TextField();
        l3.setBounds(100, 200, 150, 30);
        t3.setBounds(300, 200, 150, 30);
        
        b1 = new Button("+");
        b2 = new Button("-");
        b3 = new Button("*");
        b4 = new Button("/");
        b5 = new Button("C");
        b1.setBounds(100, 250, 30, 30);
        b2.setBounds(140, 250, 30, 30);
        b3.setBounds(180, 250, 30, 30);
        b4.setBounds(220, 250, 30, 30);
        b5.setBounds(260, 250, 30, 30);
        
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        
        // window property
        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int a, b;
        a = Integer.parseInt(t1.getText());
        b = Integer.parseInt(t2.getText());
        
        if(e.getSource() == b1) {
            t3.setText(String.valueOf(a + b));
        } else if (e.getSource() == b2) {
            t3.setText(String.valueOf(a - b));
        } else if (e.getSource() == b3) {
            t3.setText(String.valueOf(a  * b));
        } else if (e.getSource() == b4) {
            t3.setText(String.valueOf(a / b));
        } else if (e.getSource() == b5) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
        
    }
}
