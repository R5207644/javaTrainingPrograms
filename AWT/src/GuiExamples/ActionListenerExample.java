/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuiExamples;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author local user
 */
public class ActionListenerExample {
    public void actionListenerExample() {
        Frame f = new  Frame("Square");
        
        // declaring elements
        Label name = new Label("Enter your Name");
        TextField t1 = new TextField();
        Button b1 = new Button("Get Square");
        Label result = new Label(".....");
        
        // setting position of elements
        name.setBounds(100, 50, 150, 30);
        t1.setBounds(100, 100, 150, 30);
        b1.setBounds(150, 150, 70, 30);
        result.setBounds(150, 200, 100, 30);
        
        // logic
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                int num, square;
                num = Integer.parseInt(t1.getText());
                square = num * num;
                result.setText(String.valueOf(square));
            }
        }
        );
        
        // adding elements to frame
        f.add(name);
        f.add(t1);
        f.add(b1);
        f.add(result);
        
        // window properties
        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
