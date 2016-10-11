/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.code;

import Logic.Interface.CentralInterface;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author adams
 */
public class Central implements CentralInterface {

    private String Current = null;

    private static File CopyFile;

    @Override
    public String GetCurrentPath() {
        if (Current != null) {
            File Cur = new File(Current);
            if (Cur.isFile() == true || Cur.isDirectory() == true) {
                return Current;
            }
        }
        return "";
    }

    @Override
    public void SetCurrentPath(String path) {
        File Cur = new File(path);
        if (Cur.isFile() == true || Cur.isDirectory() == true) {
            Current = Cur.getPath();
        }
    }

    @Override
    public List<String[]> GetFolderContent() {
        List<String[]> temp = new LinkedList<>();
        File[] paths;
        FileSystemView fsv = FileSystemView.getFileSystemView();
        if (Current == null) {

            paths = File.listRoots();
            for (File path : paths) {
                String[] pom = new String[2];
                pom[0] = path.toString();
                pom[1] = fsv.getSystemTypeDescription(path).toString();
                temp.add(pom);
            }
            return temp;
        } else {
            File Cur = new File(Current);
            if (Cur.isDirectory() == true) {
                paths = Cur.listFiles();
                for (File path : paths) {
                    String[] pom = new String[2];
                    pom[0] = path.toString();
                    pom[1] = fsv.getSystemTypeDescription(path).toString();
                    temp.add(pom);
                }
            }
            return temp;
        }
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Copy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Paste(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Cut() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RunFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean typeOf() {
        File Cur = new File(Current);
        if (Cur.isDirectory() == true) {
            return true;
        }
        return false
    }
}

}
