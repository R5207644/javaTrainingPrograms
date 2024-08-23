package NotepadStart;

import java.awt.*;

public class NotepadLayout {

    public void notepadLayout() {
        Frame f = new Frame("Notepad");

        MenuBar mb = new MenuBar();

        Menu file = new Menu("File");
        mb.add(file);
        Menu edit = new Menu("Edit");
        mb.add(edit);
        Menu format = new Menu("Format");
        mb.add(format);
        Menu view = new Menu("View");
        mb.add(view);
        Menu help = new Menu("Help");
        mb.add(help);

        // menu items of file
        MenuItem newIcon = new MenuItem("New");
        file.add(newIcon);

        MenuItem newWindow = new MenuItem("New window");
        file.add(newWindow);

        MenuItem open = new MenuItem("open");
        file.add(open);

        MenuItem save = new MenuItem("save");
        file.add(save);

        MenuItem saveAs = new MenuItem("saveAs");
        file.add(saveAs);

        MenuItem pageSetup = new MenuItem("pageSetup");
        file.add(pageSetup);

        MenuItem print = new MenuItem("print");
        file.add(print);

        MenuItem exit = new MenuItem("exit");
        file.add(exit);

        // menu items of edit
        MenuItem undo = new MenuItem("undo");
        edit.add(undo);

        MenuItem cut = new MenuItem("cut");
        edit.add(cut);

        MenuItem copy = new MenuItem("copy");
        edit.add(copy);

        MenuItem paste = new MenuItem("paste");
        edit.add(paste);

        MenuItem delete = new MenuItem("delete");
        edit.add(delete);

        MenuItem searchWithBing = new MenuItem("search With Bing");
        edit.add(searchWithBing);

        MenuItem find = new MenuItem("find");
        edit.add(find);

        MenuItem findNext = new MenuItem("find Next");
        edit.add(findNext);

        MenuItem findPrevious = new MenuItem("find Previous");
        edit.add(findPrevious);

        MenuItem replace = new MenuItem("replace");
        edit.add(replace);

        MenuItem goTo = new MenuItem("go To");
        edit.add(goTo);

        MenuItem selectAll = new MenuItem("select All");
        edit.add(selectAll);

        MenuItem timeDate = new MenuItem("time and Date");
        edit.add(timeDate);

        // menu items of format
        MenuItem wordWrap = new MenuItem("word wrap");
        format.add(wordWrap);

        MenuItem font = new MenuItem("font");
        format.add(font);

        // menu items of view
        MenuItem zoom = new MenuItem("zoom");
        view.add(zoom);

        MenuItem statusBar = new MenuItem("status bar");
        view.add(statusBar);

        // menu item of help
        MenuItem viewHelp = new MenuItem("view help");
        help.add(viewHelp);

        MenuItem sendFeedback = new MenuItem("send feedback");
        help.add(sendFeedback);

        MenuItem about = new MenuItem("about");
        help.add(about);

        //window property
        f.setMenuBar(mb);
        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
