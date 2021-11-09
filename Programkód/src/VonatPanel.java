import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VonatPanel extends JarmuPanel {
    //private VonatJaratok jaratok;

    class EllenorzesButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            MeglevoFoglalasDialog mfd = new VonatMeglevoFoglalasDialog(getJegyek());
        }
    }
    
    public VonatPanel(MainFrame parent) {
        super(parent);
    }

    protected void initJaratok() {
        this.jaratok = new VonatJaratok();
        this.jaratok.load();
    }

    public Jegyek getJegyek() {
        return parent.getJegyek();
    }
}
