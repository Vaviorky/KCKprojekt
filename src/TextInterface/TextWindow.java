/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextInterface;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Table;
import com.googlecode.lanterna.gui.layout.HorisontalLayout;
import com.googlecode.lanterna.gui.layout.LayoutManager;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.terminal.TerminalSize;

public class TextWindow {

    final GUIScreen guiScreen = TerminalFacade.createGUIScreen();
    final Window window = new Window("Menager plikow");
    String letWindowPath = "C:";
    
    
    public void mainWindow() {
        window.setWindowSizeOverride(new TerminalSize(200,100));
        window.setSoloWindow(true);
        
        Panel panelHolder = new Panel("Cos tam", Panel.Orientation.VERTICAL);
        panelHolder.setPreferredSize(new TerminalSize(40, 50));
        Panel panel = new Panel(letWindowPath);
        panel.setLayoutManager(new HorisontalLayout());
        panel.setPreferredSize(new TerminalSize(40, 50));
        Button button = new Button("Test Button");
        button.setAlignment(Component.Alignment.RIGHT_CENTER);
        
        panel.addComponent(button, LinearLayout.GROWS_VERTICALLY);
        
        Table table = new Table(6);
        table.setColumnPaddingSize(4);
        
        Component[] row = new Component[6];
        row[0] = new Label("Plik1");
        row[1] = new Label("Plik2");
        row[2] = new Label("Plik3");
        row[3] = new Label("Plik4");
        row[4] = new Label("Plik5");
        row[5] = new Label("Plik6");
        table.addRow(row);
        panel.addComponent(table);
        
        window.addComponent(panel);
        window.addComponent(new EmptySpace());
        
        
        
        guiScreen.getScreen().startScreen();
        guiScreen.showWindow(window);
        guiScreen.getScreen().stopScreen();
    }
}
