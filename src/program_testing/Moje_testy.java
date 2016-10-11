/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_testing;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

/**
 *
 * @author Vaviorky
 */
// main Class
public class Moje_testy {

    public static void moj_test1() throws InterruptedException {  //testowe wyswietlanie jakiegos tekstu w emulowanym terminalu
        Screen screen = TerminalFacade.createScreen();
        screen.startScreen();
        screen.putString(10, 5, "SIEMANKO", Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.refresh();
        Thread.sleep(3000);
        screen.stopScreen();
        System.exit(0);
    }

    public static void moj_test2() throws InterruptedException { //jakas obsluga inputu
        Screen screen = TerminalFacade.createScreen();
        screen.startScreen();
        screen.putString(10, 5, "SIEMANKO", Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.refresh();
        StringBuilder sb = new StringBuilder();
        boolean czy_ma_dzialac = true;
        while (czy_ma_dzialac) {
            Key key = screen.readInput();
            while (key == null) {
                key = screen.readInput();
            }
            switch (key.getKind()) {
                case Escape:                                    // na Escape zamykamy program, bedzie mozna zmienic na cos innego, ale na razie to tylko testy
                    screen.stopScreen();
                    System.exit(0);
                    break;
                case Home:
                    screen.putString(15, 15, "Cos innego ale tylko jak sie wcisnie klawisz", Terminal.Color.RED, Terminal.Color.BLACK);
                    screen.refresh();                        //wazne bo inaczej nie bedziemy widziec zmian
                    break;
                case NormalKey:
                    sb.append(key.getCharacter());
                    System.out.println(key.getCharacter());
                    break;
                case Enter:
                    screen.clear();
                    screen.putString(10, 10, sb.toString(), Terminal.Color.GREEN, Terminal.Color.BLACK);
                    System.out.println(sb.toString());
                    screen.refresh();
                    break;
            }
            System.out.println("Wcisniety klawisz: " + key.getKind().toString());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        //Main_test.test3();
        //System.out.println("Nie wiem co ja tutaj robie");
        moj_test2();
    }
}