
package GuiExamples;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Sarvesh
 */
public class MouseListenerExample implements MouseListener
{
    Frame f;
    Label l;
    
    public MouseListenerExample() {
        
        f = new Frame("Mouse events");
        
        f.addMouseListener(this);
        
        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    public void mouseClicked(MouseEvent e) {
        Graphics g = f.getGraphics();
        g.setColor(Color.blue);
        
        g.fillOval(e.getX(), e.getY(), 30, 30);
    } 
    
     public void mouseEntered(MouseEvent e) {

    } 
      public void mouseExited(MouseEvent e) {

    } 
      
       public void mouseReleased(MouseEvent e) {

    } 
       
        public void mousePressed(MouseEvent e) {

    } 

    public static void main(String[] args) {
        MouseListenerExample m = new MouseListenerExample();
    }
    
}
