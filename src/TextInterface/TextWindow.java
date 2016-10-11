/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextInterface;

import Logic.code.Central;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.ActionListBox;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Table;
import com.googlecode.lanterna.gui.layout.HorisontalLayout;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.terminal.TerminalSize;
import java.util.List;

public class TextWindow {

    final GUIScreen guiScreen = TerminalFacade.createGUIScreen();
    final Window window = new Window("Menager plikow");
    String letWindowPath;
    String rightWindowPath = "SD";
    Central c = new Central();
    Panel panelLeft, panelRight;

    public void pushButton(String sth, String ads) {

    }

    public void mainWindow() {
        window.setWindowSizeOverride(new TerminalSize(500, 200));
        window.setSoloWindow(true);
        Panel panelHolder = new Panel();
        panelHolder.setLayoutManager(new HorisontalLayout());
        panelHolder.setPreferredSize(new TerminalSize(100, 100));
        panelLeft = new Panel(c.GetCurrentPath());
        panelLeft.setPreferredSize(new TerminalSize(100, 100));

        panelRight = new Panel(rightWindowPath);
        panelRight.setLayoutManager(new HorisontalLayout());
        panelRight.setPreferredSize(new TerminalSize(100, 100));

        Table table = new Table(2);
        table.setColumnPaddingSize(18);
        Component[] row = new Component[2];
        row[0] = new Label("Nazwa");
        row[1] = new Label("Typ");
        table.addRow(row);
//        row = new Component[1];
//        row[0] = new Button("...");
        List<String[]> list = c.GetFolderContent();
        
        for (String[] x : list) {
            row = new Component[2];
            ActionListBox filelist = new ActionListBox();
            filelist.addAction(x[0], new Action() {
                @Override
                public void doAction() {
                    throw new UnsupportedOperationException("CHUJA DZIALA xD");
                }
            });
            
            row[0] = filelist;
            row[1] = new Label(x[1]);
            table.addRow(row);
        }
        

        panelLeft.addComponent(table, LinearLayout.GROWS_HORIZONTALLY);
        panelHolder.addComponent(panelLeft);
        panelHolder.addComponent(panelRight);
        Panel menu = new Panel("MENU");
        menu.setPreferredSize(new TerminalSize(100, 3));
        window.addComponent(panelHolder);
        window.addComponent(menu);

        guiScreen.getScreen().startScreen();
        guiScreen.showWindow(window);
        guiScreen.getScreen().stopScreen();
    }
}
