/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextInterface;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Table;
import com.googlecode.lanterna.gui.layout.HorisontalLayout;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.terminal.TerminalSize;

public class TextWindow {

    final GUIScreen guiScreen = TerminalFacade.createGUIScreen();
    final Window window = new Window("Menager plikow");
    String letWindowPath = "C:";
    String rightWindowPath = "D:";

    public void mainWindow() {
        window.setWindowSizeOverride(new TerminalSize(500, 200));
        window.setSoloWindow(true);
        Panel panelHolder = new Panel();
        panelHolder.setLayoutManager(new HorisontalLayout());
        panelHolder.setPreferredSize(new TerminalSize(100, 100));

        Panel panelLeft = new Panel(letWindowPath);
//        panelLeft.repaint();
        panelLeft.setPreferredSize(new TerminalSize(100, 100));

        Panel panelRight = new Panel(rightWindowPath);
        panelRight.setLayoutManager(new HorisontalLayout());
        panelRight.setPreferredSize(new TerminalSize(100, 100));

        Table table = new Table(6);
        table.setColumnPaddingSize(4);

        Component[] row = new Component[2];
        row[0] = new Label("Nazwa");
        row[1] = new Label("Typ");
        table.addRow(row);
        row = new Component[1];
        row[0] = new Label("...");
        table.addRow(row);
        row = new Component[2];
        row[0] = new Label("windows.exe");
        row[1] = new Label("Trojan");
        table.addRow(row);
        panelLeft.addComponent(table, LinearLayout.GROWS_HORIZONTALLY);
        Button button = new Button("HEHEHE");
        panelLeft.addComponent(button);
        Button button1 = new Button("HEHEHE");
        panelLeft.addComponent(button1);
        panelRight.addComponent(button1);
        panelRight.addComponent(button1);
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
