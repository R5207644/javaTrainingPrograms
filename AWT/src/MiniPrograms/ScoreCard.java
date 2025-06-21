
package MiniPrograms;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Sarvesh
 */
public class ScoreCard {
    void scoreCard() {
        Frame f = new Frame("");
        
        // input unit
        Label title1 = new Label("Input Unit");
        title1.setBounds(200, 50, 150, 30);
        
        Label l1 = new Label("English");
        TextField t1 = new TextField();
        l1.setBounds(100, 100, 150, 30);
        t1.setBounds(300, 100, 150, 30);
        
        Label l2 = new Label("Computer");
        TextField t2 = new TextField();
        l2.setBounds(100, 150, 150, 30);
        t2.setBounds(300, 150, 150, 30);
        
        Label l3 = new Label("Computer");
        TextField t3 = new TextField();
        l3.setBounds(100, 200, 150, 30);
        t3.setBounds(300, 200, 150, 30);
        
        Label l4 = new Label("Computer");
        TextField t4 = new TextField();
        l4.setBounds(100, 250, 150, 30);
        t4.setBounds(300, 250, 150, 30);
        
        Label l5 = new Label("Computer");
        TextField t5 = new TextField();
        l5.setBounds(100, 300, 150, 30);
        t5.setBounds(300, 300, 150, 30);
        
        Button b1 = new Button("Calculate");
        b1.setBounds(200, 350, 150, 30);
        
        Label title2 = new Label("Result");
        title2.setBounds(550, 50, 150, 30);
        
        Label l6 = new Label("Total Marks");
        TextField t6 = new TextField();
        l6.setBounds(480, 100, 150, 30);
        t6.setBounds(650, 100, 150, 30);
        
        Label l7 = new Label("Pecentage");
        TextField t7 = new TextField();
        l7.setBounds(480, 150, 150, 30);
        t7.setBounds(650, 150, 150, 30);
        
        Label l8 = new Label("Grade");
        TextField t8 = new TextField();
        l8.setBounds(480, 200, 150, 30);
        t8.setBounds(650, 200, 150, 30);
        
        Label l9 = new Label("Status");
        TextField t9 = new TextField();
        l9.setBounds(480, 250, 150, 30);
        t9.setBounds(650, 250, 150, 30);
        
        b1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e){
               float total, percentage;
               String grade, status;
               int m1 = Integer.parseInt(t1.getText());
               int m2 = Integer.parseInt(t2.getText());
               int m3 = Integer.parseInt(t3.getText());
               int m4 = Integer.parseInt(t4.getText());
               int m5 = Integer.parseInt(t5.getText());
               
               total = m1 + m2 + m3 + m4 + m5;
               percentage = total / 5;
               if (percentage >= 80) {
                   grade = "A";
               } else if(percentage >= 70) {
                   grade = "B";
               } else if (percentage >= 60) {
                   grade = "C";
               } else if (percentage >= 34) {
                   grade = "D";
               } else {
                   grade = "E";
               }
               
               if (percentage >=34) {
                   status = "pass";
               } else {
                   status = "fail";
               }
               
               // seting values
               t6.setText(String.valueOf(total));
               t7.setText(String.valueOf(percentage));
               t8.setText(grade);
               t9.setText(status);
            }
        }
        );
        
        // adding to frame
        f.add(title1);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        f.add(b1);
        f.add(title2);
        f.add(l6);
        f.add(l7);
        f.add(l8);
        f.add(l9);
        f.add(t6);
        f.add(t7);
        f.add(t8);
        f.add(t9);
        
        
        // window
        f.setLayout(null);
        f.setSize(900, 500);
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
        ScoreCard score = new ScoreCard();
        score.scoreCard();
    }
}
