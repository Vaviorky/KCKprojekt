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
    Keyboard_listener listener;
    public void pushButton(String sth, String ads) {

    }

    public Table updateTable() {
        Table table = new Table(2);
        table.setColumnPaddingSize(18);
        Component[] row = new Component[2];
        row[0] = new Label("Nazwa");
        row[1] = new Label("Typ");
        table.addRow(row);

        row = new Component[2];
        ActionListBox filelist = new ActionListBox();
        filelist.addAction("...", new Action() {
            @Override
            public void doAction() {
                c.SetCurrentPath(c.parentDirectory());
                panelLeft.removeAllComponents();
                panelLeft.addComponent(updateTable(), LinearLayout.GROWS_HORIZONTALLY);
                panelLeft.setTitle(c.GetCurrentPath());
            }
        });

        row[0] = filelist;
        row[1] = filelist;
        table.addRow(row);
        
        List<String[]> list = c.GetFolderContent();

        for (String[] x : list) {
            row = new Component[2];
            filelist = new ActionListBox();
            filelist.addAction(x[0], new Action() {
                @Override
                public void doAction() {
                    c.SetCurrentPath(c.GetCurrentPath() + "\\" + x[0]);
                    System.out.println(c.GetCurrentPath());
                    System.out.println(x[0]);
                    panelLeft.removeAllComponents();
                    System.out.println("ssssssssssssssssssssssssssssssssssss");
                    panelLeft.addComponent(updateTable(), LinearLayout.GROWS_HORIZONTALLY);
                    panelLeft.setTitle(c.GetCurrentPath());
                }
            });

            row[0] = filelist;
            row[1] = new Label(x[1]);
            table.addRow(row);
        }
        System.out.println("kiedy return ");
        return table;

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

        Table table = updateTable();
        /*table.setColumnPaddingSize(18);
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
                    c.SetCurrentPath(c.GetCurrentPath() + x[0]);
                    
                    panelLeft.removeAllComponents();
                    panelLeft.addComponent(table, LinearLayout.GROWS_HORIZONTALLY);
                }
            });
            
            row[0] = filelist;
            row[1] = new Label(x[1]);
            table.addRow(row);
        }*/

        panelLeft.addComponent(table, LinearLayout.GROWS_HORIZONTALLY);
        panelHolder.addComponent(panelLeft);
        panelHolder.addComponent(panelRight);
        Panel menu = new Panel("MENU");
        menu.setPreferredSize(new TerminalSize(100, 3));
        window.addComponent(panelHolder);
        window.addComponent(menu);
        listener = new Keyboard_listener();
        window.addWindowListener(listener);
        guiScreen.getScreen().startScreen();
        guiScreen.showWindow(window);
        guiScreen.getScreen().stopScreen();
    }
}
