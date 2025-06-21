
package GuiExamples;
import java.awt.*;

/**
 *
 * @author local user
 */
public class Registration {
    public void details() {
        Frame frame = new Frame("Registration Page");
        
        Label l1 = new Label("Registration");
        l1.setBounds(150, 100, 200, 30);
        
        Label l2 = new Label("Name : ");
        TextField t2 = new TextField();
        
        l2.setBounds(100, 150, 100, 30);
        t2.setBounds(250, 150, 100, 30);
        
        Label l3 = new Label("Mobile");
        TextField t3 = new TextField();
        
        l3.setBounds(100, 200, 100, 30);
        t3.setBounds(250, 200, 100, 30);
        
        Label l4 = new Label("Gender");
        CheckboxGroup gender = new CheckboxGroup();
        Checkbox c1 = new Checkbox("M", gender, false);
        Checkbox c2 = new Checkbox("F", gender, false);
        
        l4.setBounds(100, 250, 100, 30);
        c1.setBounds(250, 250, 30, 30);
        c2.setBounds(300, 250, 30, 30);
        
        Label l5 = new Label("Course");
        TextField t5 = new TextField();
        
        l5.setBounds(100, 300, 100, 30);
        t5.setBounds(250, 300, 100, 30);
        
        Checkbox c3 = new Checkbox("I agree");
        c3.setBounds(100, 350, 200, 30);
        
        Button submit = new Button("Submit");
        submit.setBounds(100, 400, 200, 30);
        
        
        // adding components
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(t2);
        frame.add(t3);
        frame.add(t5);
        frame.add(c1);
        frame.add(c2);
        frame.add(c3);
        frame.add(submit);
        
        // defining window properties
        frame.setSize(400, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
