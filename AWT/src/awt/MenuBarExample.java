
package awt;

import java.awt.*;

/**
 *
 * @author sarvesh kumar
 */
public class MenuBarExample {

    void menuBarExample() {
        Frame frame = new Frame("Menu Bar Example");

        // declaring menubar
        MenuBar menubar = new MenuBar();

        // creating menu
        Menu home = new Menu("Home");
        Menu about = new Menu("about");
        Menu contact = new Menu("contact");
        Menu course = new Menu("course");

        // menu items
        MenuItem java = new MenuItem("java");
        MenuItem net = new MenuItem(".Net");
        MenuItem php = new MenuItem("PHP");

        // adding menuitem to menu
        course.add(java);
        course.add(net);
        course.add(php);

        // atting menu to menubar
        menubar.add(home);
        menubar.add(about);
        menubar.add(contact);
        menubar.add(course);

        // ading menubar to frame
        frame.setMenuBar(menubar);

        // decalaring window property
        frame.setSize(800, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
