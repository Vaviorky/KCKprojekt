/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_testing;

import Logic.Interface.CentralInterface;
import Logic.code.Central;
import java.util.List;

/**
 *
 * @author adams
 */
public class AdamTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Central c = new Central();
        List<String[]> paths = c.GetFolderContent();

        for (String[] x : paths) {
            System.out.println(x[0]);
            System.out.println(x[1]);
        }
        c.SetCurrentPath(paths.get(0)[0]);
        paths = c.GetFolderContent();

        for (String[] x : paths) {
            System.out.println(x[0]);
            System.out.println(x[1]);
        }

    }
}
