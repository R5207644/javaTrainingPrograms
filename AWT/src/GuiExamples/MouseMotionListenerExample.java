
package GuiExamples;
import java.awt.*;
import java.awt.event.*;


public class MouseMotionListenerExample implements MouseMotionListener {
    
    Frame f;
    public MouseMotionListenerExample() {
       f = new Frame("motion listener");
       
       f.addMouseMotionListener(this);
       
       f.setSize(800, 500);
       f.setLayout(null);
       f.setVisible(true);
    }
    
    public void mouseDragged(MouseEvent e) {
        Graphics g = f.getGraphics();
        g.setColor(Color.red);
        g.fillOval(e.getX(), e.getY(), 10, 10);
    }
    
    public void mouseMoved(MouseEvent e) {
    }

    
    public static void main(String[] args) {
        MouseMotionListenerExample mouse = new MouseMotionListenerExample();
    }
    
}
