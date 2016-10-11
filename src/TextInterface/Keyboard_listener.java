/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextInterface;

import com.googlecode.lanterna.gui.Interactable;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.listener.WindowListener;
import com.googlecode.lanterna.input.Key;
import javax.swing.KeyStroke;

/**
 *
 * @author Vaviorky
 */
public class Keyboard_listener implements WindowListener {

    @Override
    public void onUnhandledKeyboardInteraction(Window window, Key key) {
        if (key.getKind().equals(Key.Kind.Escape)) {
            window.close();
            System.exit(0);
        }

        switch (key.getKind()) {
            case Escape:
                window.close();
                System.exit(0);
                break;
            case F1:
                break;
            default:
                break;
        }
    }

    @Override
    public void onWindowInvalidated(Window window) {
    }

    @Override
    public void onWindowShown(Window window) {
    }

    @Override
    public void onWindowClosed(Window window) {
    }

    @Override
    public void onFocusChanged(Window window, Interactable i, Interactable i1) {
    }

}
