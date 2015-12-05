package ersn.openmc;
import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Tarek El Bardouni
 */
public class Filenamefilter extends FileFilter {
    public Filenamefilter() {
    //    Tools tools = new Tools();
    }

    @Override
    public boolean accept(File f ) {
    //    Tools tools = new Tools();
        if (f.isDirectory()){
            return true;
        }
        else {
        }
    return f.getName().startsWith(Tools.Description);
    }

    @Override
    public String getDescription() {
    //   Tools tools = new Tools();
       return Tools.Description;
}
  
}
