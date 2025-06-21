
package MiniPrograms;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Sarvesh
 */
public class FactorialCube implements ActionListener{
    
    TextField t1, t2;
    Label l1;
    Frame f;
    Button b1, b2;
    
    public FactorialCube() {
        
        f = new Frame("Factorial and Cube");
        l1 = new Label("Enter Your Number : ");
        l1.setBounds(100, 50, 150, 30);
        
        t1 = new TextField();
        t1.setBounds(100, 100, 150, 30);
        
        b1 = new Button("Get Factorial");
        b2 = new Button("Get Cube");
        b1.setBounds(100, 150, 150, 30);
        b2.setBounds(270, 150, 150, 30);
        
        t2 = new TextField();
        t2.setBounds(100, 200, 150, 30);
        
        f.add(t1);
        f.add(t2);
        f.add(l1);
        f.add(b1);
        f.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int num, fact = 1, cube;
        num = Integer.parseInt(t1.getText());
        
        if (e.getSource() == b1) {
            
            for (int i = 1; i <= num ; i++) {
                fact = fact * i;
            }
            t2.setText(String.valueOf(fact));
            
        } else if (e.getSource() == b2) {
            cube = num * num * num;
            t2.setText(String.valueOf(cube));
        }
    }
    
}
